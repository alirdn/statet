/*******************************************************************************
 * Copyright (c) 2007-2009 WalWare/StatET-Project (www.walware.de/goto/statet).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Stephan Wahlbrink - initial API and implementation
 *******************************************************************************/

package de.walware.ecommons.ui.preferences;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.RGB;

import de.walware.ecommons.databinding.AbstractSWTObservableValue;


/**
 * ObservableValue for a JFace ColorSelector.
 */
public class ColorSelectorObservableValue extends AbstractSWTObservableValue  {
	
	
	private final ColorSelector fSelector;
	
	private RGB fValue;
	
	private final IPropertyChangeListener fUpdateListener = new IPropertyChangeListener() {
		public void propertyChange(final PropertyChangeEvent event) {
			fValue = (RGB) event.getNewValue();
			fireValueChange(Diffs.createValueDiff(event.getOldValue(), fValue));
		}
	};
	
	
	/**
	 * @param selector
	 */
	public ColorSelectorObservableValue(final ColorSelector selector) {
		super(selector.getButton());
		fSelector = selector;
		
		fSelector.addListener(fUpdateListener);
	}
	
	
	@Override
	public synchronized void dispose() {
		fSelector.removeListener(fUpdateListener);
		super.dispose();
	}
	
	
	public Object getValueType() {
		return RGB.class;
	}
	
	@Override
	public void doSetValue(final Object value) {
		final RGB oldValue = fValue;
		fValue = (RGB) value;
		fSelector.setColorValue(fValue != null ? fValue : new RGB(0,0,0));
		fireValueChange(Diffs.createValueDiff(oldValue, fValue));
	}
	
	@Override
	public Object doGetValue() {
		return fSelector.getColorValue();
	}
	
}
