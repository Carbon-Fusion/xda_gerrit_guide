[CENTER][SIZE="5"][B][U]FAQ[/U][/B][/SIZE][/CENTER]

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
