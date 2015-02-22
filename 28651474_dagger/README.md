My answer to http://stackoverflow.com/questions/28651474/injecting-field-into-module-using-dagger/

In this example, the application has 2 Dagger modules: a RootModule that provides the Application Context, and a UserProfileModule which provides a single dependency that we want to inject into an Activity.

The main issue here is the importance of the direction of Dagger's module `includes`. The main/root module doesn't include all the sub-modules, it's the other way around...
