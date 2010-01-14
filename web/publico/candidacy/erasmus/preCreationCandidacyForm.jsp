<%@ page language="java"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/fenix-renderers.tld" prefix="fr"%>
<%@page import="net.sourceforge.fenixedu.presentationTier.servlets.filters.ChecksumRewriter"%>
<%@ page import="java.util.Locale"%>
<%@ page import="pt.utl.ist.fenix.tools.util.i18n.Language"%>

<%!
	static String f(String value, Object ... args) {
    	return String.format(value, args);
	}
%>

<html:xhtml/>

<bean:define id="mappingPath" name="mappingPath"/>
<bean:define id="fullPath"><%= request.getContextPath() + "/publico" + mappingPath + ".do" %></bean:define>
<bean:define id="applicationInformationLinkDefault" name="application.information.link.default"/>
<bean:define id="applicationInformationLinkEnglish" name="application.information.link.english"/>

<div class="breadcumbs">
	<%= ChecksumRewriter.NO_CHECKSUM_PREFIX_HAS_CONTEXT_PREFIX %><a href="http://gri.ist.utl.pt/en">GRI</a> &gt;
	<%= ChecksumRewriter.NO_CHECKSUM_PREFIX_HAS_CONTEXT_PREFIX %><a href="http://gri.ist.utl.pt/en/ist/">Study at IST</a> &gt;
	<%= ChecksumRewriter.NO_CHECKSUM_PREFIX_HAS_CONTEXT_PREFIX %><a href='<%= f("%s/candidacies/erasmus", request.getContextPath()) %>'><bean:message key="title.application.name.erasmus" bundle="CANDIDATE_RESOURCES"/></a> &gt;
	<bean:message key="erasmus.title.application.submission" bundle="CANDIDATE_RESOURCES" />
</div>

<h1><bean:write name="application.name" bundle="CANDIDATE_RESOURCES"/></h1>

<html:messages id="message" message="true" bundle="APPLICATION_RESOURCES" property="captcha.error" >
	<p><span class="error0"><bean:write name="message"/></span></p>
</html:messages>

<html:messages id="message" message="true" bundle="CANDIDATE_RESOURCES" property="<%= org.apache.struts.action.ActionMessages.GLOBAL_MESSAGE %>" >
	<p><span class="error0"><bean:write name="message"/></span></p>
</html:messages>

<fr:form action='<%= mappingPath + ".do?method=bindEmailWithHashCodeAndSendMailWithLink" %>'>
	<p><bean:message key="message.email.required.begin.process" bundle="CANDIDATE_RESOURCES" /></p>

	
	<bean:message key="label.email" bundle="CANDIDATE_RESOURCES" />:
	
	<fr:edit id="PublicAccessCandidacy.preCreationForm" 
		 name="candidacyPreCreationBean" 
		 type="net.sourceforge.fenixedu.presentationTier.Action.publico.candidacies.IndividualCandidacyProcessPublicDA$CandidacyPreCreationBean"
		 slot="email">
		 <fr:layout>
		 	<fr:property name="size" value="30"/>
		 	<fr:validator name="net.sourceforge.fenixedu.presentationTier.renderers.validators.RequiredEmailValidator"/>
			<fr:validator name="net.sourceforge.fenixedu.presentationTier.renderers.validators.TextLengthValidator">
				<fr:property name="type" value="character"/>
				<fr:property name="length" value="100"/>
			</fr:validator>
		 </fr:layout>
		 <fr:destination name="invalid" path='<%= mappingPath + ".do?method=preparePreCreationOfCandidacyInvalid" %>'/>
	</fr:edit>
	<span class="error0"><fr:message for="PublicAccessCandidacy.preCreationForm"/></span>
	
	<div class="mtop1 mbottom1">
		<label for="captcha"><bean:message key="label.captcha" bundle="ALUMNI_RESOURCES" />:</label>
		<div class="mbottom05">
			<img src="<%= request.getContextPath() + "/publico/jcaptcha.do" %>" style="border: 1px solid #bbb; padding: 5px;"/>
		</div>
		<span class="color777"><bean:message key="label.captcha.process" bundle="ALUMNI_RESOURCES" /></span><br/>
		<input type="text" name="j_captcha_response" size="30" style="margin-bottom: 1em;"/>
		<br/>
	</div>

	
	<p class="mtop1 mbottom0"><html:submit><bean:message key="button.continue" bundle="APPLICATION_RESOURCES" locale="en"/> �</html:submit></p>
</fr:form>

