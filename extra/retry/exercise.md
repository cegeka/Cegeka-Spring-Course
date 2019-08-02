# Gunning for that high score

It's 1984. You're 10 years old and you're trying to beat the high score on an arcade cabinet for the game 'Donkey Kong'.
To beat 'INAJ's top score of 1602 points you'll have to show your fast reflexes and on the spot improvisational skills.
However, your mother only gave you three quarters, so you only have 3 shots to get to the top of the leaderboards.

1. Read up on Spring Retry: https://www.baeldung.com/spring-retry
2. Call the REST endpoint found in ArcadeController. The underlying service takes one of your quarters to start playing and game, but will fail ('Game over') certain times at throw an exception.
Use Spring retry to catch the exception and retry instead.
3. You should retry on a GameOverException, but if you're out of coins, the service will throw an OutOfCoinsException.
In that case you should recover using a method that returns 'Player /playername\ is going home'.

##Other links
https://github.com/spring-projects/spring-retry  
https://stackoverflow.com/questions/50322126/spring-retry-method-annotated-with-recover-not-being-called
https://stackoverflow.com/questions/46979585/spring-retryable-annotation-classnotfoundexception