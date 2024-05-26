package us.muit.fs.a4i.test.model.remote;

import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import us.muit.fs.a4i.exceptions.MetricException;
import us.muit.fs.a4i.model.entities.ReportItem;
import us.muit.fs.a4i.model.remote.GitHubRepositoryEnquirer;


class GitHubRepositoryEnquirerTest {
	
	private static Logger log = Logger.getLogger(GitHubRepositoryEnquirerTest.class.getName());

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * @throws MetricException
	 */
	@Test
	void testGetTotalPullRequests() throws MetricException {
		
		System.out.println("Valor real de la ");
		log.info("dfds");
		ReportItem metrica = null;
		int numPullRequests = 20; 
        GitHubRepositoryEnquirer enquirer = new GitHubRepositoryEnquirer();
        metrica = enquirer.getMetric("pullResquestTotales", "MIT-FS/Audit4Improve-API");
        log.info(metrica.toString());
        System.out.println("Valor real de la métrica 'issues': " + metrica.getValue());
        assertEquals(numPullRequests, metrica.getValue());
		
	}
	

}