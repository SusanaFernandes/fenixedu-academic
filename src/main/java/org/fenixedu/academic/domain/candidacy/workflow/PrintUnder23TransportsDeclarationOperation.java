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
package org.fenixedu.academic.domain.candidacy.workflow;

import java.util.Collections;
import java.util.Set;

import org.fenixedu.academic.domain.Person;
import org.fenixedu.academic.domain.candidacy.Candidacy;
import org.fenixedu.academic.domain.candidacy.CandidacyOperationType;
import org.fenixedu.academic.domain.person.RoleType;
import org.joda.time.LocalDate;
import org.joda.time.Period;

public class PrintUnder23TransportsDeclarationOperation extends CandidacyOperation {

    static private final long serialVersionUID = 1L;

    public PrintUnder23TransportsDeclarationOperation(Set<RoleType> roleTypes, Candidacy candidacy) {
        super(roleTypes, candidacy);
    }

    public PrintUnder23TransportsDeclarationOperation(final RoleType roleType, final Candidacy candidacy) {
        this(Collections.singleton(roleType), candidacy);
    }

    @Override
    protected void internalExecute() {
        // nothing to be done
    }

    @Override
    public CandidacyOperationType getType() {
        return CandidacyOperationType.PRINT_UNDER_23_TRANSPORTS_DECLARATION;
    }

    @Override
    public boolean isInput() {
        return false;
    }

    @Override
    public boolean isVisible() {
        return false;
    }

    @Override
    public boolean isAuthorized(final Person person) {
        return super.isAuthorized(person) && person == getCandidacy().getPerson() && hasLessOr23Years(getCandidacy().getPerson());
    }

    private boolean hasLessOr23Years(final Person person) {
        return new Period(person.getDateOfBirthYearMonthDay(), new LocalDate()).getYears() <= 23;
    }
}