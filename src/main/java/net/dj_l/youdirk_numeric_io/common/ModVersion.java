/* This file is part of the `youdirk_numeric_io` Minecraft mod
 * Copyright (C) 2019  Dirk "YouDirk" Lehmann
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */


package net.dj_l.youdirk_numeric_io.common;
import net.dj_l.youdirk_numeric_io.*;


/**
 * Provides methods for outputing and comparing Mod versions.
 */
public class ModVersion extends NetVersion
{
  public final String MC_VERSION;
  public final int PATCH;
  public final String SUFFIX;

  public ModVersion()
  {
    super();

    this.MC_VERSION = Props.MC_VERSION;
    this.PATCH = Props.VERSION_PATCH;
    this.SUFFIX = Props.VERSION_SUFFIX;
  }

  public ModVersion(String mcVersion, int major, int api, int minor,
                    int patch, String suffix)
  {
    super(major, api, minor);

    this.MC_VERSION = mcVersion;
    this.PATCH = patch;
    this.SUFFIX = suffix;
  }

  @Override
  public String toString()
  {
    return String.format("%s-%s.%d%s", this.MC_VERSION, super.toString(),
                         this.PATCH, this.SUFFIX);
  }

  @Override
  protected long toLong()
  {
    return super.toLong()*((long)1E4) + this.PATCH;
  }
}
