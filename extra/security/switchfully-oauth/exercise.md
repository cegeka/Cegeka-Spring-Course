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

### Auth0

The author-ui is the client, the author-backend is the resource server and you will be the resource owner for this exercise.
That still leaves us with one missing component to complete the OAuth picture: the resource server.
For that part we'll be using [Auth0](https://auth0.com/). 

Auth0 offers 'OAuth as a service'. Once you configure it correctly, it'll be like connecting to any other Authorization Server.
Auth0 gives you the possibility to manage which platforms users can use to authenticate themselves (eg Google, Facebook or a database) and allows you to configure a list of permissions a client can request among many other features.
Some more advanced features are locked behind a monthly cost, but we won't be using those during this exercise.

First, you'll need to create an account. It will take you through a couple of steps.
One important step is the 'tenant' step. Here you'll have to fill in a url. This will become the issuer of your JWTs. 
You can use your first name + last name as a tenant.

After registering, you should arrive at the dashboard page. On the left side of the screen there should be a list of options. We'll create an application next.
Click on 'Applications' and 'Create application' next. 
Give your application a name (not that important) and select _Single Page Web Applications_ (*very* important). 
Now we'll have to configure your application.

Click on the application's 'Settings' tab and find the 'Allowed Callback URLs'. This is the URL of the client Auth0 will call after a user has authenticated himself via Auth0.
Fill it with 'http://localhost:4200/callback' (you can change the 'callback' part to whatever you want, but don't leave it empty or reuse any of the existing pages).
Don't forget to save the changes using the button at the bottom of the page.

The next thing we'll configure is the API. Here you can define the permissions a client can request. 
For now we'll simply create an empty API. Go to APIs and create a new one. 
The identifier is the base URL of the Resource Server (in our case, the author backend), http://localhost:8080 by default. 

### UI

And with that, we're done with Auth0 configuration (for now). Return to the author-ui so we can connect the two sides.
We'll be using a library to connect to Auth0: auth0-js. Let's install it:

npm install --save auth0-js

npm install --save-dev @types/auth0-js

The second install is so TypeScript knows which properties/methods/classes exist in the auth0-js library. 
When using the auth0-js library somewhere, add an import statement so TypeScript can assist you
(eg: import * as auth0 from 'auth0-js';).

We'll be centralizing all authentication/authorization logic in one service. Create it. We'll call the it the 'authService' from now on.
In the authService, configure the auth0 object as a field. We'll have to create a 'WebAuth' instance by doing the following:

new auth0.WebAuth({})

The JS object passed in the constructor has a couple of properties we'll have to define:

- clientID: an id you'll find in the 'Applications' tab of Auth0. 
- domain: the tenant you configured earlier
- responseType: the way the Auth0 app should answer after a user has authenticated. Set it to 'token id_token'
- audience: root url of the backend
- redirectUrl: The one you've configured in Auth0
- scope: set to 'openid' for now. We'll expand on this later

Now create a 'login' method that calls the 'authorize()' method on the field.

Call this login method when clicking on the login button. You should be redirected to Auth0's login/signup screen. 
You can log in using your facebook account or create a new account at Auth0.

After logging in using Auth0, Auth0 tries to redirect to the callback url you defined earlier with the JWT data in the url.
Since the routing for this url hasn't been configured yet, the angular routing will take over and return you back to the home page.

Configure a new 'Callback' component and update the routing in the app module so it corresponds to the url configured in Auth0.
Try logging in again. You should now already be authenticated with Auth0, so it should go a bit faster. You should arrive at the callback url after logging in, with a lot of extra data in the url.

Now we need to grab the data from the URL, store it somewhere and redirect back to the homepage. 
The field you configured to login also has a 'parseHash' method. 
This method takes a callback function with 'error' and 'authResult' parameters. 

The authResult has three important fields:
- accessToken
- idToken 
- expiresIn

The first two fields contain all data you'll need for the following exercises. 
The third one indicates how long the token will remain valid.  
You can decode the first two on [jwt.io](http://www.jwt.io) if you want to check their contents. 
If you need to decode them in code, check out [this stackoverflow post](https://stackoverflow.com/questions/38552003/how-to-decode-jwt-token-in-javascript-without-using-a-library).

If all of these are filled in, you're good to go.  Set the window.location.hash to an empty string and navigate to the home page using angular's Router.
If the error is filled in, also navigate to the home page and log the error.

Now implement the rest of this story:
- Store the authResult data in [session- or localstorage](https://alligator.io/js/introduction-localstorage-sessionstorage/). Tip: store each field as a separate entry.
- If a user is logged in, the 'log out' button should be shown instead of the 'log in' button.

## A user should be able to log out
- Clear the jwt data you stored in the previous part
- Make sure the 'log in' button reappears

## Show the user's name in the header after logging in
- Add 'profile' to the scope when authorizing a user. This will add some fields to the id token regarding the user's profile data
- Inspect the id token's fields to see the fields you'll need to use. (logging in via Facebook results in different profile properties compared to logging in using Auth0's account)

## Add feature based security

### Auth0
First, we need to head back to the Auth0 ui to configure the permissions. 
Under the API you created earlier, you'll find a 'Permissions' tab. 
Here you can create the scopes a client can request to access.
These scopes are usually defined as <>action<>:<>item<>.

Eg: a scope concerning watching television would be called 'watch:television'.

Add scopes for adding books, rating books and viewing rated books.

### UI

Next we'll need to request access to these scopes when a user is logged in. 
In the 'scope' property back in author-ui, add the names of the scopes you just added.
If you log in for the first time, you'll be notified by Auth0 that the client application wants access to some scopes.

To allow the backend to know the security privileges of the logged in user, we'll need to send the access token to the backend with every REST call we do.
In the book service, add an Authorization [header](https://stackoverflow.com/questions/35032465/angular2-http-post-headers) to every request. Its payload is 'Bearer <>access_token<>'.

### Backend

There is no security configured in our backend yet. Every REST call is still available for everyone. Let's change that.
First, make sure the correct dependencies are installed:

   		<dependency>
   			<groupId>com.auth0</groupId>
   			<artifactId>auth0-spring-security-api</artifactId>
   			<version>1.0.0-rc.3</version>
   		</dependency>
   		
Then, in the properties file, add the following properties:

auth0.issuer: <>tenant url from Auth0<>

auth0.apiAudience:<>rooturl of backend<>

Finally, we need to change the SecurityConfig.
Instead of using the regular http, we'll be working with JWT's. The following should be at the start of your configuration:

    JwtWebSecurityConfigurer
                .forRS256(apiAudience, issuer)
                .configure(http)

To secure the urls, you can once again use antMatchers or PreAuthorize annotations. 
The name of the authorities are based on how you named them in the Auth0 API.

Now implement the rest of the story:

- Everyone should be able to access the books overview page (even when not logged in)
- Any logged in user can also give ratings, add a book and navigate to the rating overview page

So hide the necessary components when the user is not logged in and show them once he is.
Also check that your backend security works by trying to perform the REST calls without the proper authorization. 
The backend should return a 40x HTTP code in that case. 

## Extra
- Adding headers to every request causes a lot of code duplication. Use an [HTTP interceptor](https://angular.io/guide/http#http-interceptors) instead
- Auth0 also offers [role based access (RBAC)](https://auth0.com/docs/authorization/concepts/rbac). Experiment with this feature.  
    - A role has a list of permissions
    - You can assign a user up to 50 roles
    - If a user logs in, he's automatically assigned the permissions coupled to the roles he has, you no longer have to request them via scope

