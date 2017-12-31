[CENTER][SIZE="5"][B][U]FAQ[/U][/B][/SIZE][/CENTER]

[SIZE="5"][B][U]Ensure your clone is up to date[/U][/B][/SIZE]
Before picking and before writing patch you need to ensure your clone is up-to-date with the remote repository. 
Go into the needed folder, then check the remote name: 
[IMG]https://forum.xda-developers.com/attachment.php?attachmentid=4375703[/IMG]
Here the remote is named 'origin'. 
We need to fetch the remote, on the right branch, then switch to that branch: 

[CODE]git fetch <remote name> <branch>[/CODE]
[IMG]https://forum.xda-developers.com/attachment.php?attachmentid=4375704[/IMG]

[CODE]git checkout <remote name>/<branch>[/CODE]
[IMG]https://forum.xda-developers.com/attachment.php?attachmentid=4375705[/IMG]
(You can notice in my right prompt the current HEAD changed for remote/<remote name>/<branch name> . It is now up to date. )

[B]Warning[/B]: Only the checkout command switch your local tree
[B]Warning[/B]: git fetch use space between remote name & branch name but git checkout use slash (/) !

[SIZE="5"][B][U]How to test pending changes[/U][/B][/SIZE]
To test a change pending on Gerrit you need a working build environment for your rom. This guide will not explain how to set it up. 
Once you have located the change you want to [URL="https://gerrit.omnirom.org/#/c/27687/"]test[/URL], 
go into the corresponding folder. Use the project path for hints: 
[IMG]https://forum.xda-developers.com/attachment.php?attachmentid=4375685[/IMG]
here folder will be device/sony/msm8974-common. 

Next use the download button into Gerrit interface 
[IMG]https://forum.xda-developers.com/attachment.php?attachmentid=4375688[/IMG]
and copy paste the command in your terminal: 

[IMG]https://forum.xda-developers.com/attachment.php?attachmentid=4375699[/IMG]
If you have merge conflict you will need to solve (with [FONT="Courier New"]git mergetool[/FONT], internet search and brain). 

Now you can do this step again to merge other commits, or trigger the build for testing. 


[SIZE="5"][B][U]Update a pending change[/U][/B][/SIZE]
You made a commit but notice some problem and it need to be reworked, without creating another one. 
You need to follow the [B][U]Ensure your clone is up to date[/U][/B] then [B][U]How to test pending changes[/U][/B] with the commit who need reworking. 
[IMG]https://forum.xda-developers.com/attachment.php?attachmentid=4375711[/IMG]

Once the commit is fetched locally you can make your changes: 
[IMG]https://forum.xda-developers.com/attachment.php?attachmentid=4375717[/IMG]

Trigger the amend of the commit: 
[CODE]git commit [B]--amend[/B][/CODE]
[IMG]https://forum.xda-developers.com/attachment.php?attachmentid=4375718[/IMG]

The git editor open and allow you to change the existing commit message: 
[IMG]https://forum.xda-developers.com/attachment.php?attachmentid=4375719[/IMG]

Once your change is done, upload it: 
[IMG]https://forum.xda-developers.com/attachment.php?attachmentid=4375724[/IMG]

The commit is updated (new Patch Set) on Gerrit (no new one was created): 
[IMG]https://forum.xda-developers.com/attachment.php?attachmentid=4375726[/IMG]
