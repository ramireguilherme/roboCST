/**
 * ****************************************************************************
 * Copyright (c) 2018  DCA-FEEC-UNICAMP
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Contributors:
 * R. G. Polizeli and R. R. Gudwin
 * ****************************************************************************
 */
package br.unicamp.cst.behavior.asbac;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author rgpolizeli
 */
public abstract class IntermediateAffordanceType {
    private AffordanceType parentAffordance; //this is necessary to diferentiate affordance type that contribute to n affordances type in the same consummatory path with different hierarchy
    private AffordanceType affordance;
    private int hierarchyContribution;
    
    public IntermediateAffordanceType(AffordanceType parentAffordance, AffordanceType aff){
        this.parentAffordance = parentAffordance;
        this.affordance = aff;
    }
    
    
    public abstract double computeAffordanceTypeBenefit(Map<String,List<Percept>> situation, Map<String,Percept> relevantPercepts);
    
    /**
     * Compute the percepts' benefits for the current situation. 
     * @param situation
     * @param relevantPercepts
     * @return
     */
    public abstract double computeParametersBenefit(Map<String,List<Percept>> situation, Map<String,Percept> relevantPercepts);
    
    public AffordanceType getAffordance(){
        return this.affordance;
    }
    
    public AffordanceType getParentAffordance(){
        return this.parentAffordance;
    }

    public int getHierarchyContribution() {
        return hierarchyContribution;
    }

    public void setHierarchyContribution(int hierarchyContribution) {
        this.hierarchyContribution = hierarchyContribution;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IntermediateAffordanceType other = (IntermediateAffordanceType) obj;
        if (this.hierarchyContribution != other.hierarchyContribution) {
            return false;
        }
        if (!Objects.equals(this.parentAffordance, other.parentAffordance)) {
            return false;
        }
        if (!Objects.equals(this.affordance, other.affordance)) {
            return false;
        }
        return true;
    }
    
}
