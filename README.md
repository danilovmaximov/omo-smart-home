# OMO semester project fraloily and maksidan

### Intro
Implementation of Smart Home assignment.

### Structure
Information about environment context such as temperature and light level
is provided via Context static class in order to make it accessible for
entities.

Same principle is applied for MapContext, it is used to get information about position of different entities, activities and rooms in the house.



Main driver of the application is a World class object:
```java
  World world = new World(house);
  world.startSimulation(50);
```
It moves entities, invokes activities, gathers consumptions and context changes, activates sensors.

House is modeled as expected: it contains floors, floors contains rooms and so on.
Each room have list of available activities and persons.

