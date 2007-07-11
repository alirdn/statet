/*******************************************************************************
 * Copyright (c) 2006 WalWare/StatET-Project (www.walware.de/goto/statet).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Stephan Wahlbrink - initial API and implementation
 *******************************************************************************/

package de.walware.statet.r.nico;

import org.eclipse.core.filesystem.IFileStore;

import de.walware.statet.nico.core.runtime.Prompt;


/**
 *
 * Note: the methods sets the properties at java side. The caller is
 * responsible for the synchronization of the properties with R.
 */
public interface ISetupRAdapter {

	public void setDefaultPromptText(String text);
	public void setIncompletePromptText(String text);
	public void setPrompt(Prompt prompt);
	
	public void setLineSeparator(String newSeparator);
	public void setWorkspaceDir(IFileStore directory);
}
