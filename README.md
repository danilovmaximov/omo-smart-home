# OMO semester project fraloily and maksidan

### Intro
Implementation of Smart Home assignment.


### Requirements
+ F1: Done(House -> Floor -> Room -> entities, activities)
+ F2: Done, ex: Current user can be added for activity.
+ F3: Done, ConsumingActivity abstract class.
+ F4: Done, ex: appendConsumptionAndGetContextChange() in House class.
+ F5: Done, ex: Mother engages in BabyCry activity, where state of baby is changes.
+ F6: Maybe, events generated: Baby, but LivingEntities actively moving.
+ F7: Done, Baby->Mom->BabyCry, TempSensor -> Dad -> Boiler
+ F8: Done, reportAPI static methods are used to get reports(to stdout or file).
+ F9: Done, 
+ F10: Done, configurable - activities could be added to entities, length of activity could be configured.

### Implemented patterns:
- Strategy: context changes according to loaded strategy.
- State machine: LivingEntity contains circular queue of activities and public method to change state(go to next activity).
- Builder: rooms, floors and house is configured through builders.
- Observer: Sensors are implemented as event managers for subscribers(Window, Father).
- Decorator - Derived classed such as Baby extends LivingEntity and contains EventManager to send messages to subscribers.
- Singleton - instead of singletons static methods and fields are used(Context, MapContext).

### Minimal configuration
Minimal configuration is done in JSON.
UMLs are in '.resources/UML/'.
Methods are mostly self-described, but small javadoc comments added.

### Structure
Information about environment context such as temperature and light level
is provided via Context static class in order to make it accessible for
entities.

Same principle is applied to MapContext, it is used to get information about position of different entities, activities and rooms in the house.

Configuration can be made directly in java class through Configurator class or loaded from 
json (example in default prefix path ./resources/json/).
```java
  World w1 = Configurator.loadHouseFromConfig("testConfig.json");
```

Main driver of the application is a World class object:
```java
  World world = new World(house);
  world.startSimulation(50);
```
It moves entities, invokes activities, gathers consumptions and context changes, activates sensors.

House is modeled as expected: it contains floors, floors contains rooms and so on.
Each room have list of available activities and persons.

LivingEntities is a base class for all actors in the application.

Activity is a base class for ConsumingActivity(have consumption).
ConsumingActivity is a base class for both ContextModifierActivity and 
ApplianceActivity. Those are derived in order to change logic of appending 
consumption transactions.

ReportsAPI contains methods to get reports to terminal or files.
Prefix in configurable in order to save it to different directories.

Reporters (reports package) have lists of transactions.
Transactions mapped, reduced, filtered and so on in order to get needed information.

Simulation uses steps to manage actions in the application.

### Step
```java
 public void startSimulation(int hours) {
        for (int i = 0; i < hours; ++i) {
            ChangeContext(); // Changes temperature, humidity... 
            house.moveEntities(); // Entities moves to room, assigned to activities
            house.doActivities(); // Steps in activities: activity state changes
            house.appendConsumptionAndGetContextChange(); // Gathering transactions.
            house.activateSensors(); // Sensors detect context.
        }
    }
```
### Events
Event could be sent to house structure(window, lights), entity(father triggered to on/off boiler),
from entity to entity for engagement(baby to mother).

### JSON parsing
Jackson library is used.






