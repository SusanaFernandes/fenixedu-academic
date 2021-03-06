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
/*
 * Created on 14/Jul/2004
 *
 */
package org.fenixedu.academic.dto;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.fenixedu.academic.domain.CurricularCourseScope;
import org.fenixedu.academic.domain.Exam;

/**
 * @author Tânia Pousão
 * 
 */
public class InfoExamWithRoomOccupationsAndScopesWithCurricularCoursesWithDegreeAndSemesterAndYear extends
        InfoExamWithRoomOccupations {

    @Override
    public void copyFromDomain(Exam exam) {
        super.copyFromDomain(exam);
        if (exam != null) {
            setAssociatedCurricularCourseScope(copyICurricularCourseScope2InfoCurricularCourseScope(exam
                    .getAssociatedCurricularCourseScopeSet()));
        }
    }

    private List copyICurricularCourseScope2InfoCurricularCourseScope(Collection associatedCurricularCourseScopes) {
        List associatedInfoCCScopes = (List) CollectionUtils.collect(associatedCurricularCourseScopes, new Transformer() {

            @Override
            public Object transform(Object arg0) {
                return InfoCurricularCourseScope.newInfoFromDomain((CurricularCourseScope) arg0);
            }
        });

        return associatedInfoCCScopes;
    }

    public static InfoExam newInfoFromDomain(Exam exam) {
        InfoExamWithRoomOccupationsAndScopesWithCurricularCoursesWithDegreeAndSemesterAndYear infoExam = null;
        if (exam != null) {
            infoExam = new InfoExamWithRoomOccupationsAndScopesWithCurricularCoursesWithDegreeAndSemesterAndYear();
            infoExam.copyFromDomain(exam);
        }

        return infoExam;
    }
}