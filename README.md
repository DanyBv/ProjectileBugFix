# ProjectileBugFix
Fixes the annoying projectile bug from Minecraft 1.9.2.

If you run a 1.9.2 server, and you use [CrackShot](http://dev.bukkit.org/bukkit-plugins/crackshot/) you may have noticed that there is a bug (from [Minecraft](https://bugs.mojang.com/browse/MC-88491)): when you shoot an entity that is too close to you, it shoots you instead.

Basically, this plugin cancels the event, so you won't get any damage from it and it sends you a configurable message (can be disabled in the config).
