---
{% comment %}
# This file is part of the `youdirk_numeric_io` Minecraft mod
# Copyright (C) 2019  Dirk "YouDirk" Lehmann
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program.  If not, see <https://www.gnu.org/licenses/>.
{% endcomment %}

---

YouDirk Numeric I/O Minecraft mod
=================================

This is the official website of the **YouDirk Numeric I/O**
`youdirk_numeric_io` Minecraft Forge mod.  It adds to the game

* **Blocks** which are **outputing decimal (and hexadecimal) numbers**
  to represent connected binary encoded Redstone Wires

* **Blocks** where you can **input a number (right click on it)**
  which will be encoded as binary and outputed to the connected
  Redstone Wires

* **Negative values** (*Two's Complement encoding*) are supported

Download
--------

You can download the current *YouDirk Numeric I/O Minecraft mod*
`youdirk_numeric_io` stable here

* **[Download stable YouDirk Numeric I/O {{ site.numeric_io.version_stable }}
     (ZIP)]({{ site.github.zip_url }})**
* **[Download stable YouDirk Numeric I/O {{ site.numeric_io.version_stable }}
     (TAR.GZ)]({{ site.github.tar_url }})**

Install
-------

To install you need *[...] TODO*

Issues & Bug reports
--------------------

If you found a *bug* or if you like to provide a *feature-request*
then take a look to the

* [**Bug Tracking System** on github.com
  ]({{site.numeric_io.github_url}}/issues)

Contributing
------------

### Wiki

You can contribute some tutorials or instructions how to use the
*YouDirk Numeric I/O Minecraft mod* by writing it down to the

* [**Wiki** on github.com
  ]({{site.numeric_io.github_url}}/wiki)

### Assets / Hacking

If you want to contribute some **code**, **assets** such like
*models*, *textures* or *sounds* then read then take a look to the
GitHub repository and read the

* [**Contribution Guidelines** on github.com
  ]({{site.numeric_io.github_url}}/blob/master/CONTRIBUTING.md)

Initial idea
------------

I want to build a [calculator in vanilla Minecraft
(twitch.tv/you_dirk)](https://www.twitch.tv/collections/jN0fzROVchV32A)
using Redstones and it's logic properties.  In conclusion it is an
8-bit ALU *(Arithmetic Logic Unit)* based on an *Intel 8085* ALU
circuit.  It should be possible to build it without using any mod.
But it's not easy to output the result of your calculation in-game and
there is no suitable way to input the operands into the calculator.
For that reason I decided to implement a mod to do that.

Well, so have fun with it :)