/* 
 * pLinguaCore: A JAVA library for Membrane Computing
 *              http://www.p-lingua.org
 *
 * Copyright (C) 2009  Research Group on Natural Computing
 *                     http://www.gcn.us.es
 *                      
 * This file is part of pLinguaCore.
 *
 * pLinguaCore is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * pLinguaCore is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with pLinguaCore.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.gcn.plinguacore.simulator.simplekernel;

import org.gcn.plinguacore.simulator.CreateSimulator;
import org.gcn.plinguacore.util.PlinguaCoreException;
import org.gcn.plinguacore.util.psystem.Psystem;
import org.gcn.plinguacore.util.psystem.factory.AbstractPsystemFactory;
import org.gcn.plinguacore.util.psystem.simplekernel.SimpleKernelLikePsystem;
import org.gcn.plinguacore.util.psystem.tissueLike.TissueLikePsystem;
import org.gcn.plinguacore.util.psystem.rule.AbstractRuleFactory;
import org.gcn.plinguacore.util.psystem.rule.checkRule.specificCheckRule.*;
import org.gcn.plinguacore.util.psystem.rule.simplekernel.KernelRuleFactory;

public class SimpleKernelPsystemFactory extends AbstractPsystemFactory {

	private static SimpleKernelPsystemFactory singleton = null;

	private SimpleKernelPsystemFactory() {
		super();
		checkRule = new NoCharges(
				new NoLeftExternalMultiSet(
						new NoRightExternalMultiSet(
								new NoConstant(
										/*new NoDissolution(	*/															new NoGeneStrings(
														new NoLeftInnerMembranes(
																new NoPriority(
																			new NoRightInnerMembranes(
																										/*new NoCooperationWithDivision())*/))))))));
	}

	public static SimpleKernelPsystemFactory getInstance() {
		if (singleton == null)
			singleton = new SimpleKernelPsystemFactory();
		return singleton;
	}

	@Override
	public CreateSimulator getCreateSimulator() throws PlinguaCoreException {
		// TODO Auto-generated method stub
		return new SimpleKernelCreateSimulator(getModelName());

	}

	@Override
	protected Psystem newPsystem() {
		// TODO Auto-generated method stub
		return new SimpleKernelLikePsystem();
	}

	@Override
	protected AbstractRuleFactory newRuleFactory() {
		// TODO Auto-generated method stub
		return new KernelRuleFactory();
	}

}
