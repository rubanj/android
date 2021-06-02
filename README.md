# Coding Assignment #

## Functional requirements

1.	Display a list of users
  1.	when app is opened , a list of users will be displayed
  2.	each entry in the list will display firstName, lastName, statusMessage
  3.	retrieve the data to populate the list from the following link: https://file.wowapp.me/owncloud/index.php/s/32EQvG6T8eYFiA2/download

2.	Add new user
  1.	after clicking on + button, display a dialog with a form which contains firstName, lastName, statusMessage and a save button
  2.	after successful user creation (200 response code) , item is added to the list
  3.	Url for user creation: https://file.wowapp.me/owncloud/index.php/s/ILsnzqADc0o3NGr/download

**(you will need to use GET method request also for creating a user and the response status code will be 200, this is because we use mock web services; adding and deleting users will not affect the list got from https://file.wowapp.me/owncloud/index.php/s/32EQvG6T8eYFiA2/download)

3.	Delete user
  1.	after long click on an item from the users list display a confirmation popup saying “Do you want to delete the user?”
  2.	after ok is clicked and delete is successful (200 response code) user is removed from the list
  3.	mock webservice url for delete user: https://file.wowapp.me/owncloud/index.php/s/uvbyRgwuSZaZ2IV/download

**(you will need to use GET method request also for deleting a user and the response status code will be 200, this is because we use mock web services; adding and deleting users will not affect the list got from https://file.wowapp.me/owncloud/index.php/s/32EQvG6T8eYFiA2/download)


### Technical requirements

1. Kotlin
2. MVVM architecture
3. Database caching
4. Use material design guidelines


## Notes

1. You are free to use whatever frameworks or tools you see fit
