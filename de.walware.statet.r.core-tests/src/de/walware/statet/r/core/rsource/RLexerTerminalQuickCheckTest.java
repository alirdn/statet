/*=============================================================================#
 # Copyright (c) 2015-2016 Stephan Wahlbrink (WalWare.de) and others.
 # All rights reserved. This program and the accompanying materials
 # are made available under the terms of the Eclipse Public License v1.0
 # which accompanies this distribution, and is available at
 # http://www.eclipse.org/legal/epl-v10.html
 # 
 # Contributors:
 #     Stephan Wahlbrink - initial API and implementation
 #=============================================================================*/

package de.walware.statet.r.core.rsource;


public class RLexerTerminalQuickCheckTest extends RLexerTerminalTest {
	
	
	@Override
	protected int getConfig() {
		return RLexer.ENABLE_QUICK_CHECK;
	}
	
	
}
