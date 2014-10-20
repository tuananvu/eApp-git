eApp ![This is a rknowsys eApp!](http://rknowsys.com/assets/img/logo.gif) 
====

### The Human Resource Application in Liferay 
<small>
[Official website](http://rknowsys.com/)&bull;
[Project Page](http://r-knowsys.github.io/eApp)

</small>

---
### Project Setup For Developers
====
1. Fork eApp. 
2. In eclipse, launch a new workspace. For example: D:\eApp\workspace_eApp
3. File --> Import --> Git --> Projects from Git --> "Select Repository Source", choose "Clone URI" option. Click Next.
4. In "Source Git Repository" enter details: URI: "https://github.com/username/eApp.git" Check that the fields are filed up for host, repository path and protocol. (Host: "github.com". repository path:"R-Knowsys/eApp.git". Protocol: "https").  Authentication: <YOUR_GITHUB_USERID> and <YOUR_GITHUB_PASSWORD> ***Note: Do not check "Store in Secure Store".
5. All branches on Github for eApp fork will be listed. Check the branch from which, you want to checkout the codebase. Example : "master"
6. Provide "Local Destination" to a folder on your system( in the same drive where Liferay server is installed, otherwise the project ant builds throws relative path errors). For example: D:\eApp. All files will be fetched from the remote branch to your system. This is location of cloned repository. Click Next.
7. On the 'select a wizard for importing projects' page, the option 'Import existing projects' is selected by default. The files start downloading. This will take few minutes depending upon internet speed.
8. 'Import Projects' page will list all the portlets projects available in the remote branch. Check all. Click Finish.
9. Open Liferay perspective. If you don't have the Liferay perspective then follow this link to get one http://www.liferay.com/community/wiki/-/wiki/Main/Liferay+IDE+Installation+Guide
10. Add a liferay server (in left bottom portion) to point to the directory where liferay 6.2 CE Server (Tomcat 7) is available. In my machine this location is D:\eApp\liferay-portal-6.2-ce-ga2\tomcat-7.0.42.
11. In sdk project, rename the build.sample.properties to build.<YOUR_USERNAME>.properties. The user I log onto my machine is 'lenovo'. So I renamed to build.lenovo.properties. Modify the contents in this file to reflect the paths on your system(Use \\ instead of \).
12. Right clicking on build.xml in services-portlet gives a context menu and then Liferay-->Build-Services. This will generate all services related classes in service-portlet-service.jar.
13. Deploy the services-portlet. The database will get generated.
14. You are all set now. Remember to send pull requests to only staging branch. Happy Coding. 


