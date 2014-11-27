![Build Status](https://api.travis-ci.org/datenstrudel/bulbs-shared.svg?branch=master)

# Bulbs-Shared

This is a supporting lib for the main project [Bulbs_Core](https://github.com/datenstrudel/bulbs-core).

It contains shared types/tools that can be used for development of client apps.



The classes located in package `net.datenstrudel.bulbs.shared.domaín.model.*` can be used within applications built
on top of this library. They provide domain data as well as some operations/algorithms to "speak the language" of light control.
For example there is an abstraction of colors, given as the abstract class `Color` as well as some
implementations (e.g. `ColorHSB`). These colors could be used in commands to be sent against the `bulbs-core` module,
deployed somewhere else, in order to apply these to actual hardware illuminants. The logic of how colors are applied to which
illuminants at which time to which concrete hardware is up to your application.

Currently this module just contains the data/classes whose direct json representations can be sent to the RESTful endpoints
provided by `bulbs-core`. A RESTful client interfacte, propably based on Spring's RestTemplate is still missing and must be implemented.

While classes within the package `net.datenstrudel.bulbs.shared.domaín.model.*` are shared between the core module and other applications,
the classes within the package `net.datenstrudel.bulbs.shared.domaín.model.client.*` are intended to be used by client applications only.

## Main Domain Classes
 As mentioned, JSON representations of the classes in `net.datenstrudel.bulbs.shared.domaín.model.client.*` are 100% compatible with
 the RESTful API of `bulbs-core`. The sub packages are sub-divided by domain concerns/ contexts.
 Thus we have a package `..client.bulb` for direct illuminant control commands as well as a gateway representation (`DtoBulbBridge`).
 Moreover there is an `identity` context for identity and authentication concerns, containing a user abstracting class.

 Most interestingly you find the `Dto*Cmd` classes, representing commands that can be sent against the core module. With these commands you
 can express the actual light behavior your application has determined to be applied.
 The following command classes currently exist:

 * `DtoBulbActuationCmd` allows you to directly control specific, single illuminants. Can contain many `BulbState`s in order to realize state transitions over time.
 * `DtoGroupActuatorCmd`  allows you to control groupings of illuminants, that must have been created before as `DtoGroup`s
 * `DtoPresetActuatorCmd`  allows you to trigger specific presets that must have been created before as `DtoPreset`s

 Illuminants are represented as `Bulb`s.
 Moreover you can create schedules using `DtoScheduledActuation` classes.

<p><small>.. more documentation will follow soon..</small></p>


