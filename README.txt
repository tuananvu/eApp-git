eApp


====


Project Setup

---------------------


1. In eclipse, launch a new workspace. For example: D:\eApp\workspace_eApp



2. File -> Import -> Git -> Projects from Git -> "Source Git Repository", enter details:
a. URI: https://github.com/R-Knowsys/eApp.git
b. Authentication: <YOUR_GITHUB_USERID> and <YOUR_GITHUB_PASSWORD>
***Note: Do not check "Store in Secure Store".



3. All branches on Github for eApp project will be listed. Check the branch from 

which, you want to checkout the codebase. Example : "master"



4. Provide "Local Storage Destination" to a folder on you system. For example: D:

\eApp

Click Next. All files will be fetached from the remote branch to your system.



5. Import Projects will list all the portlets projects available in the remote branch. 

Select all. Click Finish.



6. Open LIferay perspective.



7. Add a liferay server to point to the directory where liferay 6.2 CE Server (Tomcat 

7) is available.



8. In sdk project, rename the build.sample.properties to 

build.<YOUR_USERNAME>.properties. Modify the properties in this file to reflect the 

paths on your system.



9. Run "build-service" target in the ant build.xml available in services-portlet project. 

This will generate all services related code in service-portlet-service.jar.



10. Run the default target "all" in the ant build.xml file in sdk project. This will start 

building all the portlets.



11. Do all changes in you need to in your workspace. 



12. When you are done, go to "Synchronize Workspace". 



13. On conflicts, do a manual merge. On others do Merge.



14. Commit - add a meaningful comments. You may add a reference to redmine Feature # or Bug #.



15. 

To resolve a conflict, navigate to the conflicting resource, edit the content of the conflicting resource, tell EGit that the conflict is resolved with Team -> Add. 

16. Before commit, got to Window -> Show View -> Git Staging, add verify the staged files as they appear in Staged Changes. Do a Commit.

17. Team -> Push now. If you get the "rejected - non-fast forward" error, do a fetch to check that there is nothing to update. Then, Push to Upstream. 

18. To verify that the last commit on Github has no issues, chekout the code in a local repository and run the project build by following steps 1 to 10. There should be not errors while running the builds.
