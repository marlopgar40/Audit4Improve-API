package us.muit.fs.a4i.test.model.remote;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import us.muit.fs.a4i.exceptions.MetricException;
import us.muit.fs.a4i.model.entities.ReportItem;
import us.muit.fs.a4i.model.remote.GitHubRepositoryEnquirer;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

class GitHubRepositoryEnquirerTest {

    private static Logger log = Logger.getLogger(GitHubRepositoryEnquirerTest.class.getName());

    @Mock
    private GitHub gitHub;

    @Mock
    private GHRepository ghRepository;

    @InjectMocks
    private GitHubRepositoryEnquirer enquirer;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testGetTotalPullRequests() throws MetricException {
        String repositoryId = "MIT-FS/Audit4Improve-API";
        String metricName = "issues";
        int numPullRequests = 20;

        when(gitHub.getRepository(repositoryId)).thenReturn(ghRepository);
        when(ghRepository.getIssues(any())).thenReturn(Collections.nCopies(numPullRequests, new Object()));

        ReportItem metrica = enquirer.getMetric(metricName, repositoryId);

        log.info(metrica.toString());
        System.out.println("Valor real de la métrica 'issues': " + metrica.getValue());
        assertEquals(numPullRequests, metrica.getValue());
    }
}
