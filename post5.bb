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
