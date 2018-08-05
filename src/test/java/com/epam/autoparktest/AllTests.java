package com.epam.autoparktest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AppTest.class, CredentialsTest.class, LogFileTest.class, SlotsArrangementTest.class, SlotTest.class,
		TransactionFileTest.class, ValidationTest.class })
public class AllTests {

}
