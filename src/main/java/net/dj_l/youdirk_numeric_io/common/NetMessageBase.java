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
 * This class is a work-around for the poor Java Generics type
 * checking.  Use this type for <code>NetMessageRegistry</code> stuff.
 */
public abstract class NetMessageBase
  extends YoudirkNumericIORegistryEntry<NetMessageBase>
{
  /**
   * <b>The HashCode of the <code>registryPath</code> is used as
   * NetworkID for your message!</b> For this reason, do not rename it
   * to hold the network protocol compatible.
   */
  protected NetMessageBase(String registryPath)
  {
    super(NetMessageBase.class);

    this.setRegistryName(registryPath);
  }

  public int getNetId()
  {
    return this.getRegistryName().getPath().hashCode();
  }
}
