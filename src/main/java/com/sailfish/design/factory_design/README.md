## 简单工厂

- BeanFactory
- ApplicationContext


Let's look at the benefits of the Factory pattern:
The Factory pattern promotes loose coupling between collaborating componentsor classes by using interfaces rather than binding application-specific classesinto the application code
Using this pattern, you can get an implementation of an object of classes thatimplement an interface, at runtime
The object life cycle is managed by the factory implemented by this pattern
Now let's discuss some common problems where you should apply the Factorydesign pattern:
This pattern removes the burden on the developer to create and manage theobjects
This pattern removes the tight coupling between collaboration componentsbecause a component doesn't know what subclasses it will be required to create
Avoid hard code to create an object of the class
