 eApp
====

Project Setup
---------------------

1. In eclipse, launch a new workspace. For example: D:\eApp\workspace_eApp

2. File -> Import -> Git -> Projects from Git -> "Select Repository Source", choose "Clone URI" option. Click Next.

In "Source Git Repository" enter details:
 
URI: "https://github.com/R-Knowsys/eApp.git" Check that the fields are filed up for host, repository path and protocol. (Host: "github.com". repository path:"R-Knowsys/eApp.git". Protocol: "https"). 
Authentication: <YOUR_GITHUB_USERID> and <YOUR_GITHUB_PASSWORD>
***Note: Do not check "Store in Secure Store".

3. All branches on Github for eApp project will be listed. Check the branch from which, you want to checkout the codebase. Example : "master"

4. Provide "Local Destination" to a folder on your system( in the same drive where Liferay server is installed, otherwise the project ant builds throws relative path errors). For example: D:
\eApp. All files will be fetched from the remote branch to your system. This is location of cloned repository. 

Click Next.

5. On the 'select a wizard for importing projects' page, the option 'Import existing projects' is selected by default. The files start downloading. This will take few minutes depending upon internet speed.

6. 'Import Projects' page will list all the portlets projects available in the remote branch. Check all. Click Finish.

7. Open Liferay perspective. If you don't have the Liferay perspective then follow this link to get one http://www.liferay.com/community/wiki/-/wiki/Main/Liferay+IDE+Installation+Guide

8. Add a liferay server (in left bottom portion) to point to the directory where liferay 6.2 CE Server (Tomcat 7) is available. In my machine this location is D:\eApp\liferay-portal-6.2-ce-ga2\tomcat-7.0.42.

9. In sdk project, rename the build.sample.properties to build.<YOUR_USERNAME>.properties. The user I log onto my machine is 'lenovo'. So I renamed to build.lenovo.properties. Modify the contents in this file 
to reflect the paths on your system(Use \\ instead of \).

10. Right clicking on build.xml in services-portlet gives a context menu and then Liferay->Build-Services. This will generate all services related classes in service-portlet-service.jar.

11. In sdk project right click on build.xml. Liferay-> SDK-> all. Run "build-service" target in the ant build.xml(Right click on build.xml->Liferay->SDK->build-service) available in services-portlet project. This will generate all services related code in service-portlet-service.jar. This will start building all the portlets.

12. Do all changes in you need to in your workspace. 

13. When you are done, go to "Synchronize Workspace". 

14. On conflicts, do a manual merge. On others do Merge.

15. Commit - add a meaningful comments. You may add a reference to redmine Feature # or Bug #.

16.To resolve a conflict, navigate to the conflicting resource, edit the content of the conflicting resource, tell EGit that the conflict is resolved with Team -> Add. 

17. Before commit, go to Window -> Show View -> Git Staging, add verify the staged files as they appear in Staged Changes. Do a Commit.

18. Team -> Push now. If you get the "rejected - non-fast forward" error, do a fetch to check that there is nothing to update. Then, Push to Upstream. 

19. To verify that the last commit on Github has no issues, checkout the code in a local repository and run the project build by following steps 1 to 10. There should be not errors while running the builds.
