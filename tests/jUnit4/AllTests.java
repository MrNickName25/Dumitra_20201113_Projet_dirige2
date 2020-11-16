package jUnit4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCorespondence.class, TestLogiciel.class, TestMenace.class, TestPerimetre.class, TestSolution.class,
		TestUser.class })
public class AllTests {

}
