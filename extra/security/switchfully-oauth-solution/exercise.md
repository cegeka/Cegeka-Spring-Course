The author application allows people to:
- add books
- give the added books a rating between 1 - 5 stars

# Exercises
## Check if the application runs as expected
- Backend: run the main class
- UI: npm install + ng serve

You should be able to
- see 3 books when opening the application on localhost:4200
- add a book by clicking the 'add' button on the right side of the page
- give a book a rating by clicking the stars to the right of its name/author
- see an average of all of a books ratings by navigating to the 'ratings' page and see the names of all people who rated it by hovering over the rating score
- the log in button should do nothing 

## A user should be able to log in by clicking the 'Log in' button
- If a user is logged in, the 'log out' button should be shown instead of the 'log in' button
- Store the jwt in [session- or localstorage](https://alligator.io/js/introduction-localstorage-sessionstorage/)
- When logged in, show the text 'Hello <firstname> <lastname>' in the header

TODO: info on how to implement this

## A user should be able to log out
- Clear the jwt data you stored in the previous part
- Make sure the 'log in' button reappears

## Add feature based security
- Everyone should be able to access the books overview page (even when not logged in)
- Any logged in user can also give ratings and navigate to the rating overview page
- Securing the 'Adding books' feature is something we'll address in the next exercise

