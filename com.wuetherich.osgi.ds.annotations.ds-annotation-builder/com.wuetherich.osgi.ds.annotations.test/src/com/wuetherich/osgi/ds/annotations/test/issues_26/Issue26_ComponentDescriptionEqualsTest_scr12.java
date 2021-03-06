package com.wuetherich.osgi.ds.annotations.test.issues_26;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;
import org.osgi.xmlns.scr.v1_2.Tcomponent;
import org.osgi.xmlns.scr.v1_2.TconfigurationPolicy;
import org.osgi.xmlns.scr.v1_2.Timplementation;
import org.osgi.xmlns.scr.v1_2.TjavaTypes;
import org.osgi.xmlns.scr.v1_2.Tpolicy;
import org.osgi.xmlns.scr.v1_2.Tproperties;
import org.osgi.xmlns.scr.v1_2.Tproperty;
import org.osgi.xmlns.scr.v1_2.Treference;
import org.osgi.xmlns.scr.v1_2.Tservice;

import com.wuetherich.osgi.ds.annotations.internal.componentdescription.impl.AbstractComponentDescription;
import com.wuetherich.osgi.ds.annotations.internal.componentdescription.impl.SCR_1_2_ComponentDescription;

public class Issue26_ComponentDescriptionEqualsTest_scr12 {

	@Test
	public void test() throws Exception {

		//
		JAXBContext context = JAXBContext.newInstance(Tcomponent.class, TconfigurationPolicy.class, Timplementation.class,
		          TjavaTypes.class, Tpolicy.class, Tproperties.class, Tproperty.class, Treference.class, Tservice.class);;
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		//
		@SuppressWarnings("unchecked")
		JAXBElement<Tcomponent> jaxbElement1 = (JAXBElement<Tcomponent>) unmarshaller
				.unmarshal(new File(
						"src/com/wuetherich/osgi/ds/annotations/test/issues_26/Issue26_ComponentDescriptionEqualsTest_scr12.xml"));
		Tcomponent tcomponent1 = jaxbElement1.getValue();

		//
		@SuppressWarnings("unchecked")
		JAXBElement<Tcomponent> jaxbElement2 = (JAXBElement<Tcomponent>) unmarshaller
				.unmarshal(new File(
						"src/com/wuetherich/osgi/ds/annotations/test/issues_26/Issue26_ComponentDescriptionEqualsTest_scr12.xml"));
		Tcomponent tcomponent2 = jaxbElement2.getValue();
		
		//
		assertTrue(SCR_1_2_ComponentDescription.equals(tcomponent1, tcomponent2));
		tcomponent1.setDeactivate("deactivate");
		assertFalse(SCR_1_2_ComponentDescription.equals(tcomponent1, tcomponent2));
	}
}
