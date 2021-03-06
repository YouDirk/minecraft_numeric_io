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


package net.dj_l.youdirk_numeric_io.debug;
import net.dj_l.youdirk_numeric_io.common.*;
import net.dj_l.youdirk_numeric_io.*;

// Server
import net.dj_l.youdirk_numeric_io.server.Command;


/**
 * This class is used as super class for ingame <code>/debug-* arg1
 * arg2...</code> commands to make it possible to filter them out.
 */
public abstract class CommandDebug<T extends CommandDebug<T>>
  extends Command<T>
{
  private final static String _COMMAND_NAME_PREEFIX = "debug-";

  /**
   * A default constructor without any parameter must be implemented
   * to instanciate dummy objects.  It can be empty, but
   * <code>super(String commandName)</code> must be called.
   */
  protected CommandDebug(String debugCommandName)
  {
    super(_COMMAND_NAME_PREEFIX + debugCommandName);
  }
}
