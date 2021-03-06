/**
 * Copyright © 2002 Instituto Superior Técnico
 *
 * This file is part of FenixEdu Academic.
 *
 * FenixEdu Academic is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * FenixEdu Academic is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with FenixEdu Academic.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.fenixedu.academic.service.services.commons.searchers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.fenixedu.academic.domain.organizationalStructure.Party;
import org.fenixedu.academic.domain.organizationalStructure.PartySocialSecurityNumber;
import org.fenixedu.bennu.core.domain.Bennu;
import org.fenixedu.bennu.core.presentationTier.renderers.autoCompleteProvider.AutoCompleteProvider;

public class SearchPartiesBySocialSecurityNumber implements AutoCompleteProvider<Party> {

    @Override
    public Collection<Party> getSearchResults(Map<String, String> argsMap, String value, int maxCount) {
        final List<Party> parties = new ArrayList<Party>();
        for (final PartySocialSecurityNumber partySocialSecurityNumber : Bennu.getInstance().getPartySocialSecurityNumbersSet()) {
            if (partySocialSecurityNumber.getSocialSecurityNumber().indexOf(value) >= 0) {
                parties.add(partySocialSecurityNumber.getParty());
            }
        }
        return parties;
    }

}
