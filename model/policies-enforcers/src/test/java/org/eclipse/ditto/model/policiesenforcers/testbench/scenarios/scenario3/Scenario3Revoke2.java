/*
 * Copyright (c) 2017 Bosch Software Innovations GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/org/documents/epl-2.0/index.php
 *
 * Contributors:
 *    Bosch Software Innovations GmbH - initial contribution
 */
package org.eclipse.ditto.model.policiesenforcers.testbench.scenarios.scenario3;

import java.util.Collections;

import org.eclipse.ditto.model.policiesenforcers.testbench.scenarios.Scenario;
import org.eclipse.ditto.model.policiesenforcers.testbench.scenarios.ScenarioSetup;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;


@State(Scope.Benchmark)
public class Scenario3Revoke2 implements Scenario3Revoke {

    private final ScenarioSetup setup;

    public Scenario3Revoke2() {
        final String resource = "/attributes";
        setup = Scenario.newScenarioSetup(
                false,
                "Subject has READ+WRITE granted on '/'. Subject has READ+WRITE revoked on '" + resource + "'." +
                        " Subject has READ granted on '/attributes/location'." +
                        " Is NOT able to READ+WRITE '" + resource + "'",
                getPolicy(),
                Scenario.newAuthorizationContext(SUBJECT_ALL_GRANTED_ATTRIBUTES_REVOKED),
                resource,
                Collections.emptySet(),
                "READ", "WRITE");
    }

    @Override
    public ScenarioSetup getSetup() {
        return setup;
    }

}
