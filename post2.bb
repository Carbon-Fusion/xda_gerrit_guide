[B][CENTER][U][SIZE="5"]Making Changes and Submitting Patches :D -[/SIZE][/U][/CENTER][/B] 
[SIZE="5"][B][U]Way 1. (for recurrent contribute) : [/U][/B][/SIZE]

If you have a full build environment setup, the best practice say to [B]not use[/B] your build trees for change & submit patches. If you do not have build environment setup, just don't care about this warning ;)

Create a folder (like ~/clones/) where your clones with your changes will reside: 
[CODE]mkdir ~/clones
cd ~/clones[/CODE]
[INDENT][IMG="mkdir ~/clones"]https://forum.xda-developers.com/attachment.php?attachmentid=4363119[/IMG][/INDENT]

Go to git where you would make the change and copy the [I]Clone link[/I]:
[CODE]https://github.com/omnirom/android_device_sony_shinano-common.git[/CODE]
[INDENT][IMG="git clone link"]https://forum.xda-developers.com/attachment.php?attachmentid=4363130[/IMG][/INDENT]

Go back into your terminal and clone the repo ([I]optional[/I]: you can specify the branch name with -b <branch name>), then get into clone folder: 
[INDENT][IMG="git clone shinano"]https://forum.xda-developers.com/attachment.php?attachmentid=4363131[/IMG][/INDENT]

Now you can make the change using your favorite text editor (<escape> then ':q<enter>' to exit vim :p):
[INDENT][IMG="vim edition"]https://forum.xda-developers.com/attachment.php?attachmentid=4363137[/IMG][/INDENT]

[CODE]git status[/CODE]
It tells you what files you modified(In [COLOR="red"]Red color[/COLOR] ) and shows on which branch you're currently on. ;)
[IMG="git status"]https://forum.xda-developers.com/attachment.php?attachmentid=4363138[/IMG]

Now, the committing part,
Run:
[CODE]git add -A[/CODE]
Run git status again, and it'll show the files in green color, telling you that the changes have been added. ;)
[INDENT][IMG="git status pending"]https://forum.xda-developers.com/attachment.php?attachmentid=4363140[/IMG][/INDENT]
Now:
[CODE]git commit -s[/CODE]
This will commit the changes and open up a Text Editor called [I]NANO[/I]. Here you need to edit the commit message that appears at the side of the gerrit window to describe what the patch does. ;)
After writing the commit message, press Ctrl+O and then Enter key to save the commit message and then Ctrl+X to exit the editor. This is the committing part done. :D :good:

[INDENT][IMG="git commit -s"]https://forum.xda-developers.com/attachment.php?attachmentid=4363148[/IMG][/INDENT]

[I]Optional[/I] (but better ;)): you can control what your commit changed, then rework if necessary (see last part of the guide):  
[CODE]git diff HEAD^ [/CODE]
[INDENT][IMG="git diff HEAD^"]https://forum.xda-developers.com/attachment.php?attachmentid=4363158[/IMG][/INDENT]


[B]Now submitting the patch - [/B]
You need to catch the project path from the Gerrit interface. Go into project, list, and find the repository you changed: 
[INDENT][IMG="gerrit project path"]https://forum.xda-developers.com/attachment.php?attachmentid=4363174[/IMG][/INDENT]
Here the path is [I]android_device_sony_shinano-common[/I]. It could include a 'sub-folder' like LineageOS do. For example, same repo on Lineage will be [I]LineageOS/android_device_sony_shinano-common[/I]. 
[B]WARNING[/B]: path is case sensitive. 
Go back to your shell and type: 
[CODE]git push ssh://<username>@<gerrit address>:29418/<repo path> HEAD:refs/for/<branch name>[/CODE]
[INDENT][IMG="git push"]https://forum.xda-developers.com/attachment.php?attachmentid=4363187[/IMG][/INDENT]
