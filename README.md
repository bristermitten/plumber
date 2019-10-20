# Plumber

[![Build Status](https://travis-ci.com/knightzmc/plumber.svg?branch=master)](https://travis-ci.com/knightzmc/plumber) [![](https://jitpack.io/v/knightzmc/Plumber.svg)](https://jitpack.io/#knightzmc/Plumber)

Plumber is a framework for the Spigot API to reduce the amount of boilerplate it takes to create high qualtity Minecraft plugins. With all frameworks, it has a learning curve, but the simple DSL and Spring Boot-style annotatation based system makes it easy to pick up. It also encourages best practices - as long as you use what's provided, you'll find yourself writing cleaner, more organised code that does away with static abuse, string concatenation for config files, and messy, buggy event handlers.

At the moment, it's in its infancy, but the potential that comes with Plumber is limitless.

### Benefits of Plumber
* Lack of Boilerplate - No more `CommandExecutor`, `public static MyPlugin getPlugin()`, and messy Inventory slot checking. Plumber includes Aikar's powerful [ACF](https://github.com/aikar/commands) for annotation based command handling, and will soon hook in with [Fluency](https://github.com/knightzmc/spigotmenus/tree/dev), a beautifully simple Inventory API. If that's not enough, [Guice](https://github.com/google/guice/) brings powerful dependency injection, and Plumber's Configuration library makes working with YAML files effortless.
* Spigot Compatibility - The Spigot API still exists, don't worry. Any libraries for Spigot will work with Plumber, and if you need that hidden away API component that isn't Plumberified yet, nothing's stopping you from using it.
* Kotlin Support - Kotlin is a JVM-based language that does away with the long winded syntax of Java, and brings hundreds of useful features with it. Much of Plumber is written in Kotlin, and we highly recommend giving it a try!
* The Plumber DSL - Inspired by Guice's simple English-based Module configuration DSL, Plumber uses a functional, method chaining approach that results in incredibly readable code that looks something like this
```java
for (PPlayer player : server.players()) {
    if (player.lastMoved().moreThan(30).seconds().ago()) {
        player.kick("Kicked for AFK.");
    }
}
```
It's a thing of beauty.


### Get Started
Take a look at the [Wiki](https://github.com/knightzmc/plumber/wiki)
