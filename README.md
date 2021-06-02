# Coding Assignment #

Functional requirements

1.	Display a list of users
a.	when app is opened , a list of users will be displayed
b.	each entry in the list will display firstName, lastName, statusMessage
c.	retrieve the data to populate the list from the following link: https://file.wowapp.me/owncloud/index.php/s/32EQvG6T8eYFiA2/download

2.	Add new user
a.	after clicking on + button, display a dialog with a form which contains firstName, lastName, statusMessage and a save button
b.	after successful user creation (200 response code) , item is added to the list
c.	Url for user creation:
https://file.wowapp.me/owncloud/index.php/s/ILsnzqADc0o3NGr/download

(you will need to use GET method request also for creating a user and the response status code will be 200, this is because we use mock web services; adding and deleting users will not affect the list got from https://file.wowapp.me/owncloud/index.php/s/32EQvG6T8eYFiA2/download)

3.	Delete user
a.	after long click on an item from the users list display a confirmation popup saying “Do you want to delete the user?”
b.	after ok is clicked and delete is successful (200 response code) user is removed from the list
c.	mock webservice url for delete user:
https://file.wowapp.me/owncloud/index.php/s/uvbyRgwuSZaZ2IV/download

(you will need to use GET method request also for deleting a user and the response status code will be 200, this is because we use mock web services; adding and deleting users will not affect the list got from https://file.wowapp.me/owncloud/index.php/s/32EQvG6T8eYFiA2/download)


Technical requirements:

a.	Kotlin
b.	MVVM architecture
c.	Database caching
d.	Use material design guidelines


Notes:

a.	You are free to use whatever frameworks or tools you see fit
