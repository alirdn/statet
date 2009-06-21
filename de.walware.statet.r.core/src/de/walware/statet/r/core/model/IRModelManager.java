/*******************************************************************************
 * Copyright (c) 2009 WalWare/StatET-Project (www.walware.de/goto/statet).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Stephan Wahlbrink - initial API and implementation
 *******************************************************************************/

package de.walware.statet.r.core.model;

import java.util.List;

import org.eclipse.core.resources.IProject;

import de.walware.ecommons.ltk.IModelManager;


public interface IRModelManager extends IModelManager {
	
	
	IRFrame getProjectFrame(IProject project);
	
	List<String> findReferencingSourceUnits(IProject project, RElementName name);
	
}
