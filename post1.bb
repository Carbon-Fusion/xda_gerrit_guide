[B][U][SIZE="5"][CENTER]Purposes of this guide[/CENTER][/SIZE][/U][/B]
This guide want to be a how-to use Gerrit, allowing everyone to contribute on AOSP like projects. 
Divided in 3 parts: 
[LIST=1]
[*]Now few important stuff needs to be setup before proceeding- [I]-> Minimal setup to use Gerrit. [/I]
[*][URL="https://forum.xda-developers.com//general/xda-university/guide-using-gerrit-code-review-t3720802/post74875046"]How to setup & submit for recurent contributes[/URL]
[*][URL="https://plus.google.com/share?url=https://forum.xda-developers.com//general/xda-university/guide-using-gerrit-code-review-t3720802/post74875049"]How to submit patches one time[/URL]
[/LIST]
Here we will setup [B]clones[/B], [COLOR="Red"]outside of the build tree[/COLOR]. See [URL="https://forum.xda-developers.com//general/xda-university/guide-using-gerrit-code-review-t3720802/post74876750"]faq[/URL] for commit testing. 
This mean you do not need build environement to contribute :cool:

Important: for projects using Gerrit, Github [COLOR="red"]pull request will never be merged[/COLOR]! This also mean you [B]do not need to create a Github fork[/B] for every changed projects :victory:

[B][U][SIZE="5"][CENTER]So firstly, I'll explain few terms that are important for you to learn before going towards a bit tricky side. ;)[/CENTER][/SIZE][/U][/B]

[LIST=1]
[*][B][U]Git[/U][/B] - To be precise, [B]git[/B] is a code-sharing website/software that allows you to share your project resources you can 'Make Software, better, together'(That's what the tag line says :p )!

Now, before I go to gerrit, read this: Major Open Source Projects, like, CyanogenMod, AOKP, OmniROM etc. don't directly accept [B]pull requests[/B] and in case you want to make a change in their source for a fix/feature or anything, you need to send them [B]patches[/B] over [B]gerrit[/B] which are then reviewed by the trusted members of the community and if they find it valuable enough, gets merged into the git repository!

[*][B][U]Gerrit[/U][/B](Copying the definition from Wiki) - Gerrit is a free, web-based team software code review tool. Software developers in a team can review each other's modifications on their source code using a Web browser and approve or reject those changes. It integrates closely with Git, a distributed version control system.
So, now, git and gerrit are so closely related, that a patch verified over gerrit can directly be merged on git without much hassel, also please note that [COLOR="Red"]your gerrit and git username must be same.[/COLOR]

[*][B][U]Pull Requests[/U][/B] -  Pull requests are sent over Git after you fork a repository, make some changes into it and then want the owner to merge those changes into his repository, and that's how community development and Open Source works. :)

[*][B][U]Patches[/U][/B] - In simple terms, any changes you make to repos of Open Source Projects like LineageOS, OmniRom or AOKP and send them over gerrit for code review are called Patches. 
You can find the Gerrit URL of the project you are working on, on the contribute webpage of the project. Example: OmniRom gerrit is [url]https://gerrit.omnirom.org/[/url] , LineageOS is [url]https://review.lineageos.org/[/url]
[/LIST]

[B][U][CENTER][SIZE="5"]How GERRIT works?! :confused:[/SIZE][/CENTER][/U][/B]
[B]Now, Gerrit is deployed in place of this central repository and adds an additional concept, a store of pending changes. Everyone still fetches from the authoritative repository but instead of pushing back to it, they push to this pending changes location. A change can only be submitted into the authoritative repository and become an accepted part of the project once the change has been reviewed and approved.
I found a nice diagram explaining this over the internet that will clear your doubts(if any :p) :) -[/B]
[IMG]http://i.stack.imgur.com/2lCom.png[/IMG]

There is two different way to use gerrit: 
[LIST=1]
[*]With git , on your computer (useful for recurrent contribute)
[*]Using the Gerrit WebUI (useful for punctual contribute)
[/LIST]

[CENTER][B][U][SIZE="5"]Now few important stuff needs to be setup before proceeding-[/SIZE][/U][/B][/CENTER]

[B]Install up Git:[/B]
[HIDE]Debian/Ubuntu: [CODE]sudo apt-get install git[/CODE]
Fedora: [CODE]yum install git[/CODE]
ArchLinux: [CODE]pacman -S git[/CODE]
openSUSE: [CODE]zypper install git[/CODE][/HIDE]

[B]Configuring git:[/B]
This step is very very important as those ID will be the one which identify you and you [B]cannot change[/B] them later!
[B]WARNING[/B]: You [B]need[/B] to setup the same email as on github.com ! 
[B]WARNING[/B]: email is [B]case sensitive[/B]! 
(For username I highly recommend to use the same as on your computer, but you could use any username you want)
[HIDE][CODE]git config --global user.email "your-email@domain.com"[/CODE]
[CODE]git config --global user.name "your-username"[/CODE][/HIDE]

[B]Setting up SSH Keys[/B](Skip this if you have already set them up) - 
[CODE]ssh-keygen -t rsa -C "your-email@domain.com"[/CODE]
[INDENT][IMG="ssh-keygen"]https://forum.xda-developers.com/attachment.php?attachmentid=4363089[/IMG][/INDENT]

[B]Now this will create 2 files in ~/.ssh directory as follows:[/B]
[INDENT][IMG="ll ~/.ssh"]https://forum.xda-developers.com/attachment.php?attachmentid=4363090[/IMG][/INDENT]

[B]Adding SSH Keys to your Account : [/B]
[CODE]cat /home/username_on_pc/.ssh/id_rsa.pub[/CODE]
This will show up few lines over terminal, copy those and add them into your Gerrit profile (Will not be detailed, there is a lot of guides on internet for this part) ;)
[INDENT][IMG="cat ~/.ssh/id_rsa.pub"]https://forum.xda-developers.com/attachment.php?attachmentid=4363077[/IMG]
[IMG="Gerrit ssh key setting"]https://forum.xda-developers.com/attachment.php?attachmentid=4363078[/IMG][/INDENT]
[B]Important[/B]: you need to setup your username into gerrit UI, otherwise you will never be able to push changes (on the screenshot there is no option to modify username as it is already setup but you should see one): 
[INDENT][IMG="gerrit username setup"]https://forum.xda-developers.com/attachment.php?attachmentid=4363097[/IMG][/INDENT]

[B]Test ssh is correctly working : [/B]
[CODE]ssh -p 29418 <username>@<gerrit address>[/CODE]
If you see this message, then everything is setup and ready to propose changes : 
[INDENT][IMG="ssh test"]https://forum.xda-developers.com/attachment.php?attachmentid=4363166[/IMG][/INDENT]
If you get any errors, reread the howto to ensure you are not missing something. 
You can also contact your team (there is probably an IRC channel for this) and ask for help.

[B]Setting up the hook [I]Change-ID[/I] : [/B]
[B]WARNING[/B]: this need to be done in every repository or upload will fail! 
[CODE]gitdir=$(git rev-parse --git-dir); scp -p -P 29418 <username>@<gerrit address>:hooks/commit-msg ${gitdir}/hooks/[/CODE]
[INDENT][IMG="gerrit hook"]https://forum.xda-developers.com/attachment.php?attachmentid=4363186[/IMG][/INDENT]
