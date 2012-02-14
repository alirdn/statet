/*******************************************************************************
 * Copyright (c) 2010-2012 WalWare/StatET-Project (www.walware.de/goto/statet).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Stephan Wahlbrink - initial API and implementation
 *******************************************************************************/

package de.walware.statet.r.internal.debug.core;

import org.eclipse.debug.core.DebugException;

import de.walware.statet.r.core.model.ArgsDefinition;
import de.walware.statet.r.core.model.ArgsDefinition.Arg;
import de.walware.statet.r.core.model.IRMethod;


public class RFunctionValue extends RValue {
	
	
	public RFunctionValue(final RElementVariable variable) {
		super(variable);
	}
	
	
	@Override
	public String getValueString() throws DebugException {
		if (fVariable.fElement instanceof IRMethod) {
			final IRMethod lang = (IRMethod) fVariable.fElement;
			final StringBuilder sb = new StringBuilder();
			final ArgsDefinition args = lang.getArgsDefinition();
			sb.append("function(");
			if (args == null) {
				sb.append("<unknown>");
			}
			else if (args.size() > 0) {
				{	final Arg arg = args.get(0);
					if (arg.name != null) {
						sb.append(arg.name);
					}
				}
				{	for (int i = 1; i < args.size(); i++) {
						sb.append(", ");
						final Arg arg = args.get(i);
						if (arg.name != null) {
							sb.append(arg.name);
						}
					}
				}
			}
			sb.append(")");
			return sb.toString();
		}
		return super.getValueString();
	}
	
}
