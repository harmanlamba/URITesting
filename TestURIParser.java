package uriparser;  // DO NOT CHANGE THIS OR YOU WILL GET ZERO


import org.junit.Test;

import static org.junit.Assert.*;

/**
 * SOFTENG 254 2018 Assignment 1 submission
 * <p>
 * Author: (Harman Lamba, hlam132)
 **/

public class TestURIParser {// DO NOT CHANGE THE CLASS NAME OR YOU WILL GET ZERO

    // Your tests here.

    /**
     * This test checks to see if a null value is passed, the implementation throws the correct ParseException exception
     * as indicated by the JavaDoc, to see if the requirements provided are being met.
     */
    @Test(timeout = 5000)
    public void testNullThrowingException() {
        try {
            URIParser uriparser = new URIParser();
            URI uri = uriparser.parse(null);
            fail();
        } catch (uriparser.ParseException e) {
        }

    }


    /**
     * This test checks and ensures that the basic functionality of the scheme is correct, i.e. is the jar able to
     * identify the scheme, when there is a full URI. This test adds to the quality of the test suite as it ensures
     * basic functionality by the parser.
     */
    @Test(timeout = 5000)
    public void testBasicSchemeFunctionality() {
        URI uri = new URIParser().parse("scheme://authority/path?Query#Fragment");
        assertEquals("scheme", uri.getScheme());
    }

    /**
     * This test checks and ensures that the basic functionality of the authority is correct, i.e. is the jar able to
     * identify the authority, when there is a full URI. This test adds to the quality of the test suite as it ensures
     * basic functionality by the parser.
     */
    @Test(timeout = 5000)
    public void testBasicAuthorityFunctionality() {
        URI uri = new URIParser().parse("scheme://authority/path?Query#Fragment");
        assertEquals("authority", uri.getAuthority());
    }

    /**
     * This test checks and ensures that the basic functionality of the path is correct, i.e. is the jar able to
     * identify the path, when there is a full URI. This test adds to the quality of the test suite as it ensures
     * basic functionality by the parser.
     */
    @Test(timeout = 5000)
    public void testBasicPathFunctionality() {
        URI uri = new URIParser().parse("scheme://authority/path?Query#Fragment");
        assertEquals("/path", uri.getPath());
    }

    /**
     * This test checks and ensures that the basic functionality of the query is correct, i.e. is the jar able to
     * identify the query, when there is a full URI. This test adds to the quality of the test suite as it ensures
     * basic functionality by the parser.
     */
    @Test(timeout = 5000)
    public void testBasicQueryFunctionality() {
        URI uri = new URIParser().parse("scheme://authority/path?Query#Fragment");
        assertEquals("Query", uri.getQuery());
    }

    /**
     * This test checks and ensures that the basic functionality of the fragment is correct, i.e. is the jar able to
     * identify the fragment, when there is a full URI. This test adds to the quality of the test suite as it ensures
     * basic functionality by the parser.
     */
    @Test(timeout = 5000)
    public void testBasicFragmentFunctionality() {
        URI uri = new URIParser().parse("scheme://authority/path?Query#Fragment");
        assertEquals("Fragment", uri.getFragment());
    }

    /**
     * This test checks, given that the scheme is null that the authority that is given by the parser is correct
     * The whole URI is used in this case, as depending on the implementation having a null element in the URI, might
     * potentially shift the whole URI or make it so the parser cannot identify it. The null/non-existing value is
     * being tested as null tends to cause unexpected behaviour, thus it is viable to test for it.
     */

    @Test(timeout = 5000)
    public void testNullSchemeCheckingAuthority() {
        URI uri = new URIParser().parse("//authority/path?Query#Fragment");
        assertNull(uri.getScheme());
        assertEquals("authority", uri.getAuthority());
    }


    /**
     * This test checks, given that the scheme is null that the path that is given by the parser is correct
     * The whole URI is used in this case, as depending on the implementation having a null element in the URI, might
     * potentially shift the whole URI or make it so the parser cannot identify it. The null/non-existing value is being
     * tested as null tends to cause unexpected behaviour, thus it is viable to test for it.Transitions are tested later on
     * which are different.
     */
    @Test(timeout = 5000)
    public void testNullSchemeCheckingPath() {
        URI uri = new URIParser().parse("//authority/path?Query#Fragment");
        assertNull(uri.getScheme());
        assertEquals("/path", uri.getPath());
    }

    /**
     * This test checks, given that the scheme is null that the query that is given by the parser is correct
     * The whole URI is used in this case, as depending on the implementation having a null element in the URI, might
     * potentially shift the whole URI or make it so the parser cannot identify it. The null/non-existing value is
     * being tested as null tends to cause unexpected behaviour, thus it is viable to test to ensure correct behaviour.
     */
    @Test(timeout = 5000)
    public void testNullSchemeCheckingQuery() {
        URI uri = new URIParser().parse("//authority/path?Query#Fragment");
        assertNull(uri.getScheme());
        assertEquals("Query", uri.getQuery());
    }
    /**
     * This test checks, given that the scheme is null that the fragment that is given by the parser is correct
     * The whole URI is used in this case, as depending on the implementation having a null element in the URI, might
     * potentially shift the whole URI or make it so the parser cannot identify it. The null/non-existing value is being
     * tested as null tends to cause unexpected behaviour, thus it is viable to test to ensure correct behaviour.
     */
    @Test(timeout = 5000)
    public void testNullSchemeCheckingFragment() {
        URI uri = new URIParser().parse("//authority/path?Query#Fragment");
        assertNull(uri.getScheme());
        assertEquals("Fragment", uri.getFragment());
    }

    /**
     * This tests checks, given that the authority is null that the parser can still correctly identity the scheme. The
     * whole URI is used, as the implementation is unknown, and it could be that based on the implementation having a
     * null authority could in-fact report the wrong scheme by the parser. The null/non-existing value is being
     * tested as null tends to cause unexpected behaviour, thus it is viable to test to ensure correct behaviour.
     */
    @Test(timeout = 5000)
    public void testNullAuthorityCheckingScheme() {
        URI uri = new URIParser().parse("scheme:/path?Query#Fragment");
        assertNull(uri.getAuthority());
        assertEquals("scheme", uri.getScheme());
    }
    /**
     * This tests checks, given that the authority is empty that the parser can still correctly identity the scheme. The
     * whole URI is used, as the implementation is unknown, and it could be that based on the implementation having an
     * empty authority could in-fact report the wrong scheme the wrong scheme by the parser. The null/non-existing
     * value is being tested as null tends to cause unexpected behaviour, thus it is viable to test to ensure correct
     * behaviour.
     */
    @Test(timeout = 5000)
    public void testEmptyAuthorityCheckingScheme() {
        URI uri = new URIParser().parse("scheme:///news?Query#Fragment");
        assertEquals("",uri.getAuthority());
        assertEquals("scheme", uri.getScheme());
    }

    /**
     * This tests checks, given that the authority is null that the parser can still correctly identity the authority
     * as being null. The whole URI is used, as the implementation is unknown, and it could be that based on the
     * implementation having a null authority could in-fact report the wrong authority. The null/non-existing value is
     * being tested as null tends to cause unexpected behaviour, thus it is viable to test for to ensure correct behaviour.
     */
    @Test(timeout = 5000)
    public void testNullAuthorityCheckingAuthority() {
        URI uri = new URIParser().parse("scheme:/path?Query#Fragment");
        assertNull(uri.getAuthority());
    }

    /**
     * This tests checks, that given an empty authority if the parser can correctly return the authority as being empty.
     * As with the cases above the full URI is used, as we are not aware of the implementation, thus the elements of the
     * URI could behave differently when all together. The empty value is being tested as empty values are a special case
     * that the implementation should be able to handle.
     */
    @Test(timeout = 5000)
    public void testEmptyAuthorityCheckingAuthority() {
        URI uri = new URIParser().parse("scheme:///path?Query#Fragment");
        assertEquals("", uri.getAuthority());
    }

    /**
     * This test checks, that given a null authority that the path of the URI is reported correctly by the parser. A full
     * URI is used, due to the same reasons mentioned above. The null/non-existing value is being tested as having a URI
     * with no authority is viable, thus it is viable to test for to ensure correct behaviour.
     */
    @Test(timeout = 5000)
    public void testNullAuthorityCheckingPath() {
        URI uri = new URIParser().parse("urn:rfc:3986");
        assertNull(uri.getAuthority());
        assertEquals("rfc:3986", uri.getPath());
    }


    /**
     * This test checks that given an empty authority, that the correct path is being reported by the parser.
     * The empty value is being tested as empty values are a special case that the implementation should be able to
     * handle.
     */
    @Test(timeout = 5000)
    public void testEmptyAuthorityCheckingPath() {
        URI uri = new URIParser().parse("file:///etc/fstab");
        assertEquals("",uri.getAuthority());
        assertEquals("/etc/fstab", uri.getPath());
    }

    /**
     * This test checks that given a null authority a correct query is reported by the parser. The null value is being
     * tested as null tends to cause unexpected behaviour, thus it is viable to test for to ensure correct behaviour.
     */
    @Test(timeout = 5000)
    public void testNullAuthorityCheckingQuery() {
        URI uri = new URIParser().parse("scheme:/path?Query#Fragment");
        assertNull(uri.getAuthority());
        assertEquals("Query", uri.getQuery());
    }

    /**
     * This test checks that given an empty authority a correct query is reported by the parser. The empty value is
     * being tested as empty values are a special case that the implementation should be able to handle.
     */
    @Test(timeout = 5000)
    public void testEmptyAuthorityCheckingQuery() {
        URI uri = new URIParser().parse("scheme:///path?://Query#Fragment");
        assertEquals("",uri.getAuthority());
        assertEquals("://Query", uri.getQuery());
    }

    /**
     * This test checks that given a null authority the correct fragment is reported by the parser. The null value is
     * being tested as null tends to cause unexpected behaviour, thus it is viable to test for to ensure correct behaviour.
     */
    @Test(timeout = 5000)
    public void testNullAuthorityCheckingFragment() {
        URI uri = new URIParser().parse("scheme:/path?Query#Fragment");
        assertNull(uri.getAuthority());
        assertEquals("Fragment", uri.getFragment());
    }

    /**
     * This test checks that given an empty authority that the parser correctly identifies the fragment of the URI
     * The empty value is being tested as empty values are a special case that the implementation should be able to
     * handle, as noted by the requirements.
     */
    @Test(timeout = 5000)
    public void testEmptyAuthorityCheckingFragment() {
        URI uri = new URIParser().parse("scheme:///path?Query#Fragment");
        assertEquals("",uri.getAuthority());
        assertEquals("Fragment", uri.getFragment());
    }

    /**
     * This test checks that given a null path, the parser correctly identifies the scheme of the URI. Since the impleme-
     * tation is not known, a full URI is used to ensure that having a null path in the full URI will not make the
     * parser report the wrong Scheme, thus it is viable to test for to ensure correct behaviour of the parser
     * with a null value for path.
     */
    @Test(timeout = 5000)
    public void testNullPathCheckingScheme() {
        URI uri = new URIParser().parse("https://authority?Query#Fragment");
        assertNull(uri.getPath());
        assertEquals("https", uri.getScheme());
    }

    /**
     * This test checks that given a null path the parser correctly identifies the authority of the URI. The null value
     * is being tested as null tends to cause unexpected behaviour, thus it is viable to test for to ensure correct behaviour.
     */
    @Test(timeout = 5000)
    public void testNullPathCheckingAuthority() {
        URI uri = new URIParser().parse("https://authority?Query#Fragment");
        assertNull(uri.getPath());
        assertEquals("authority", uri.getAuthority());
    }

    /**
     * This test checks that given a null path the parser correctly identifies the path as being null and reports it,
     * when the path is not alone rather a full URI is provided. The null value is being tested as null tends to cause
     * unexpected behaviour, thus it is viable to test for to ensure correct behaviour..
     */
    @Test(timeout = 5000)
    public void testNullPathCheckingPath() {
        URI uri = new URIParser().parse("https://authority?Query#Fragment");
        assertNull(uri.getPath());
    }

    /**
     * This test checks that given a null path the parser correctly identifies the query in the URI. The null value
     * is being tested as null tends to cause unexpected behaviour, thus it is viable to test for to ensure correct behaviour.
     */
    @Test(timeout = 5000)
    public void testNullPathCheckingQuery() {
        URI uri = new URIParser().parse("https://authority?Query#Fragment");
        assertNull(uri.getPath());
        assertEquals("Query", uri.getQuery());
    }

    /**
     * This test checks that given a null path the parser correctly identifies the fragment in the URI. The null value
     * is being tested as null tends to cause unexpected behaviour, thus it is viable to test for to ensure correct behaviour.
     */
    @Test(timeout = 5000)
    public void testNullPathCheckingFragment() {
        URI uri = new URIParser().parse("https://authority?Query#Fragment");
        assertNull(uri.getPath());
        assertEquals("Fragment", uri.getFragment());
    }
    /**
     * This test checks that given a null query that the parser correctly identifies the Scheme. The null value
     * is being tested as null tends to cause unexpected behaviour, thus it is viable to test for to ensure correct behaviour.
     */
    @Test(timeout = 5000)
    public void testNullQueryCheckingScheme() {
        URI uri = new URIParser().parse("https://authority/path/path#Fragment");
        assertNull(uri.getQuery());
        assertEquals("https", uri.getScheme());
    }

    /**
     * This test checks that given an empty query that the parser correctly identifies the scheme in the full URI provided.
     * This test improves the quality of the test suite as it is quite plausible that an empty Query can be provided,
     * thus we must test to ensure it behaves accordingly, thus the test ensures the correct behaviour is implemented.
     */
    @Test(timeout = 5000)
    public void testEmptyQueryCheckingScheme() {
        URI uri = new URIParser().parse("https://authority/path/path?#Fragment");
        assertEquals("",uri.getQuery());
        assertEquals("https", uri.getScheme());
    }

    /**
     * This test checks that given a null query the parser correctly identifies the authority in the full URI. This test
     * improves the quality of the test suite as having a null/non-existing query is completely viable thus, we need to ensure that
     * the implementations can handle such behaviour correctly.
     */
    @Test(timeout = 5000)
    public void testNullQueryCheckingAuthority() {
        URI uri = new URIParser().parse("https://authority/path/path#Fragment");
        assertNull(uri.getQuery());
        assertEquals("authority", uri.getAuthority());
    }

    /**
     * This test checks that given an empty query that the parser correctly identifies the authority in the full URI.
     * This test improves the quality of the test suite as it is quite plausible that an empty Query can be provided,
     * thus we must test to ensure it behaves accordingly, thus the test ensures the correct behaviour is implemented.
     */
    @Test(timeout = 5000)
    public void testEmptyQueryCheckingAuthority() {
        URI uri = new URIParser().parse("https://authority/path/path?#Fragment");
        assertEquals("",uri.getQuery());
        assertEquals("authority", uri.getAuthority());
    }

    /**
     * This test checks that given a null query the parser correctly identifies the path in the full URI. This test
     * improves the quality of the test suite as having a null/non-existing query is completely viable thus,
     * we need to ensure that the implementations can handle such behaviour.
     */
    @Test(timeout = 5000)
    public void testNullQueryCheckingPath() {
        URI uri = new URIParser().parse("https://authority/path/path#Fragment");
        assertNull(uri.getQuery());
        assertEquals("/path/path", uri.getPath());
    }

    /**
     * This test checks that given an empty query that the parser can correctly identify the path in the full URI.
     * This test improves the quality of the test suite as it is quite plausible that an empty Query can be provided,
     * thus we must test to ensure it behaves accordingly, thus the test ensures the correct behaviour is implemented.
     */
    @Test(timeout = 5000)
    public void testEmptyQueryCheckingPath() {
        URI uri = new URIParser().parse("https://authority/path/path?#Fragment");
        assertEquals("",uri.getQuery());
        assertEquals("/path/path", uri.getPath());
    }

    /**
     * This test checks that given a null query that the parser can identify that the full URI has a null query.This test
     * improves the quality of the test suite as having a null/non-existing query is completely viable thus, we need to
     * ensure that the implementations can handle such behaviour correctly.
     */
    @Test(timeout = 5000)
    public void testNullQueryCheckingQuery() {
        URI uri = new URIParser().parse("https://authority/path/path#Fragment");
        assertNull(uri.getQuery());
    }

    /**
     * This test checks that given a empty query the parser can correctly identify that an empty query has been given in
     * the full URI. This test improves the quality of the test suite as it is quite plausible that an empty Query can
     * be provided, thus we must test to ensure it behaves accordingly, thus the test ensures the correct behaviour
     * is implemented.
     */
    @Test(timeout = 5000)
    public void testEmptyQueryCheckingQuery() {
        URI uri = new URIParser().parse("https://authority/path/path?#Fragment");
        assertEquals("",uri.getQuery());
    }

    /**
     * This test checks that given a null query, that the parser correctly identifies the fragment from the full URI.
     * This test improves the quality of the test suite as having a null/non-existing query is completely viable
     * thus, we need to ensure that the implementations can handle such behaviour correctly.
     */
    @Test(timeout = 5000)
    public void testNullQueryCheckingFragment() {
        URI uri = new URIParser().parse("https://authority/path/path#Fragment");
        assertNull(uri.getQuery());
        assertEquals("Fragment", uri.getFragment());
    }

    /**
     * This test checks that given an empty query, the parser correctly identifies the fragment from the complete URI.
     * This test improves the quality of the test suite as it is quite plausible that an empty Query can be provided,
     * thus we must test to ensure it behaves accordingly, thus the test ensures the correct behaviour is implemented.
     */
    @Test(timeout = 5000)
    public void testEmptyQueryCheckingFragment() {
        URI uri = new URIParser().parse("https://authority/path/path?#Fragment");
        assertEquals("",uri.getQuery());
        assertEquals("Fragment", uri.getFragment());

    }
    /**
     * This test checks that given a null fragment, that the parser can correctly identify the scheme from the complete
     * URI. This test improves the quality of the test suite as having a null/non-existing fragment is completely viable
     * thus, we need to ensure that the implementations can handle such behaviour correctly.
     */
    @Test(timeout = 5000)
    public void testNullFragmentCheckingScheme() {
        URI uri = new URIParser().parse("https://authority/path/path?Query");
        assertNull(uri.getFragment());
        assertEquals("https", uri.getScheme());
    }

    /**
     * The test checks that given an empty fragment, that the parser can correctly identify the correct scheme from the
     * complete URI. This test improves the quality of the test suite as it is quite plausible that an empty Fragment can
     * be provided, thus we must test to ensure it behaves accordingly, thus the test ensures the correct behaviour
     * is implemented.
     */
    @Test(timeout = 5000)
    public void testEmptyFragmentCheckingScheme() {
        URI uri = new URIParser().parse("https://authority/path/path?Query#");
        assertEquals("",uri.getFragment());
        assertEquals("https", uri.getScheme());
    }

    /**
     * The test checks that given a null fragment the parser can correctly identify the authority. This test
     * improves the quality of the test suite as having a null/non-existing fragment is completely viable thus,
     * we need to ensure that the implementations can handle such behaviour correctly.
     */
    @Test(timeout = 5000)
    public void testNullFragmentCheckingAuthority() {
        URI uri = new URIParser().parse("https://authority/path/path?Query");
        assertNull(uri.getFragment());
        assertEquals("authority", uri.getAuthority());
    }

    /**
     * This test checks that given an empty fragment the parser can correctly identify the authority. This test improves
     * the quality of the test suite as it is quite plausible that an empty Fragment can be provided, thus we must test
     * to ensure it behaves accordingly, thus the test ensures the correct behaviour is implemented.
     */
    @Test(timeout = 5000)
    public void testEmptyFragmentCheckingAuthority() {
        URI uri = new URIParser().parse("https://authority/path/path?Query#");
        assertEquals("",uri.getFragment());
        assertEquals("authority", uri.getAuthority());
    }

    /**
     * This test checks that given a null fragment, that the parser can correctly identify the path. This test
     * improves the quality of the test suite as having a null/non-existing fragment is completely viable thus, we need
     * to ensure that the implementations can handle such behaviour correctly.
     */
    @Test(timeout = 5000)
    public void testNullFragmentCheckingPath() {
        URI uri = new URIParser().parse("https://authority/path/path?Query");
        assertNull(uri.getFragment());
        assertEquals("/path/path", uri.getPath());
    }

    /**
     * This test checks that given an empty fragment the parser correctly identifies the path. This test improves
     * the quality of the test suite as it is quite plausible that an empty Fragment can be provided, thus we must test
     * to ensure it behaves accordingly, thus the test ensures the correct behaviour is implemented.
     */
    @Test(timeout = 5000)
    public void testEmptyFragmentCheckingPath() {
        URI uri = new URIParser().parse("https://authority/path/path?Query#");
        assertEquals("",uri.getFragment());
        assertEquals("/path/path", uri.getPath());
    }

    /**
     * This test checks that given a null fragment the parser correctly identifies the query in the full URI. This test
     * improves the quality of the test suite as having a null/non-existing fragment is completely viable thus, we need
     * to ensure that the implementations can handle such behaviour correctly.
     */
    @Test(timeout = 5000)
    public void testNullFragmentCheckingQuery() {
        URI uri = new URIParser().parse("https://authority/path/path?Query");
        assertNull(uri.getFragment());
        assertEquals("Query", uri.getQuery());
    }

    /**
     * This test checks that given an empty fragment the parser correctly identifies the correct query. This test improves
     * the quality of the test suite as it is quite plausible that an empty Fragment can be provided, thus we must test
     * to ensure it behaves accordingly, thus the test ensures the correct behaviour is implemented.
     */
    @Test(timeout = 5000)
    public void testEmptyFragmentCheckingQuery() {
        URI uri = new URIParser().parse("https://authority/path/path?Query#");
        assertEquals("",uri.getFragment());
        assertEquals("Query", uri.getQuery());
    }

    /**
     * This test checks that given a null fragment the parser can identify the fragment as being null. This test
     * improves the quality of the test suite as having a null/non-existing fragment is completely viable thus, we need
     * to ensure that the implementations can handle such behaviour correctly.
     */
    @Test(timeout = 5000)
    public void testNullFragmentCheckingFragment() {
        URI uri = new URIParser().parse("https://authority/path/path?Query");
        assertNull(uri.getFragment());
    }

    /**
     * This test checks that given an empty fragment the parser can identify the fragment as being empty. This test improves
     * the quality of the test suite as it is quite plausible that an empty Fragment can be provided, thus we must test
     * to ensure it behaves accordingly, thus the test ensures the correct behaviour is implemented.
     */
    @Test(timeout = 5000)
    public void testEmptyFragmentCheckingFragment() {
        URI uri = new URIParser().parse("https://authority/path/path?Query#");
        assertEquals("",uri.getFragment());
    }

    /**
     * This test checks that given an empty authority, query and fragment that the parser can correctly identify those three
     * elements as being empty, even though it is an unlikely case, it is viable and since empty authority, query, and
     * fragment can be supplied they must be tested to ensure the implementation is giving the right behaviour. This
     * case differs to the others, as it tests only the special characters and no legal strings. It is important to note
     * that the transition is not being tested in this case, rather just if the implementations are able to handle
     * empty elements of the URI correctly.
     */
    @Test(timeout = 5000)
    public void testEmptyAuthorityQueryAndFragment() {
        URI uri = new URIParser().parse("//?#");
        assertEquals("", uri.getAuthority());
        assertEquals("", uri.getQuery());
        assertEquals("", uri.getFragment());
    }

    /**
     * This test checks that the correct path gets reported by the parser, given that the query, and fragment are empty
     * This case adds quality to the test suite, as it ensures that the implementations are able to handle empty values
     * starting from the path, unlike the previous test where they started from the authority. As it suffices for one
     * elements coding of the empty to potentially cause unexpected behaviour in the remaining URI elements, therefore
     * it must be tested.
     */
    @Test(timeout = 5000)
    public void testPathWithEmptyQueryAndFragment() {
        URI uri = new URIParser().parse("://?#");
        assertEquals("://", uri.getPath());
        assertEquals("", uri.getQuery());
        assertEquals("", uri.getFragment());
    }

    /**
     * This test checks that if just the scheme was provided in the URI, that the parser can correctly identify it as
     * the scheme. This test adds the to quality of the suite, as this test ensures that even if just a single element
     * of the URI is given, the parser is able to identify it and return the right values.
     */
    @Test(timeout = 5000)
    public void testJustScheme() {
        URI uri = new URIParser().parse("scheme:");
        assertEquals("scheme",uri.getScheme());
    }
    /**
     * This test checks that if just the authority was provided in the URI, that the parser can correctly identify it as
     * the authority. This test adds the to quality of the suite, as this test ensures that even if just a single element
     * of the URI is given, the parser is able to identify it and return the right values.
     * This also tests the transition from a null scheme to an authority
     */
    @Test(timeout = 5000)
    public void testJustAuthority() {
        URI uri = new URIParser().parse("//authority");
        assertEquals("authority", uri.getAuthority());
    }
    /**
     * This test ensures that all the implementations handle other special characters that are allowed to be part of the
     * authority such as ':' , and can identity it correctly as the Authority.
     */
    @Test(timeout = 5000)
    public void testSpecialCharactersInJustAuthority() {
        URI uri = new URIParser().parse(("//:Authority"));
        assertEquals(":Authority", uri.getAuthority());
    }

    /**
     * This test checks that if just the path is provided in the URI, the parser is able to correctly identify it.
     * This test adds the to quality of the suite, as this test ensures that even if just a single element
     * of the URI is given, the parser is able to identify it and return the right values. This also tests the
     * transition from a null scheme to a path.
     */
    @Test(timeout = 5000)
    public void testJustPath() {
        URI uri = new URIParser().parse("/path");
        assertEquals("/path", uri.getPath());
    }

    /**
     * This test ensures that all the implementations handle other special characters that are allowed to be part of the
     * path such as ':','/' , and can identify it correctly as the path.
     */
    @Test(timeout = 5000)
    public void testSpecialCharactersInJustPath(){
        URI uri = new URIParser().parse("/:path");
        assertEquals("/:path", uri.getPath());
    }

    /**
     * This test checks that if just the query is provided in the URI, the parser is able to correctly identify it.
     * This test adds the to quality of the suite, as this test ensures that even if just a single element of the URI
     * is given, the parser is able to identify it and return the right values. This test implicitly also tests that
     * the transition from a null scheme to a query is implemented correctly.
     */
    @Test(timeout = 5000)
    public void testJustQuery() {
        URI uri = new URIParser().parse("?Query");
        assertEquals("Query", uri.getQuery());
    }

    /**
     * This test ensures that all the implementations handle other special characters that are allowed to be part of the
     * query such as ':','/' ,'//' and can identify it correctly as the query.
     */
    @Test(timeout = 5000)
    public void testSpecialCharactersInJustQuery() {
        URI uri = new URIParser().parse("?://Query");
        assertEquals("://Query", uri.getQuery());
    }

    /**
     * This test checks that if just the fragment is provided in the URI, the parser is able to correctly identify it.
     * This test adds the to quality of the suite, as this test ensures that even if just a single element of the URI
     * is given, the parser is able to identify it and return the right values. This test implicitly also tests that
     * the transition from a null scheme to a fragment is implemented correctly.
     */
    @Test(timeout = 5000)
    public void testJustFragment() {
        URI uri = new URIParser().parse("#Fragment");
        assertEquals("Fragment", uri.getFragment());
    }

    /**
     * This test ensures that all the implementations handle other special characters that are allowed to be part of the
     * fragment such as ':','/' ,'//','#','?' and can identity it correctly as the fragment.
     */

    @Test(timeout = 5000)
    public void testSpecialCharactersInJustFragment() {
        URI uri = new URIParser().parse("#://?#Fragment");
        assertEquals("://?#Fragment", uri.getFragment());
    }

    /**
     * This test checks to see that if the parser having no legal character and just the special characters is able to
     * distinguish between the different elements in the URI correctly. This test improves the quality of the test suite
     * since it ensures that the parser is able to correctly distinguish the special characters for each element of the
     * URI when, given as a full URI, rather than individually. That is tested specifically later.
     */
    @Test(timeout = 5000)
    public void testJustSpecialCharacters(){
        URI uri=new URIParser().parse(":///:?#:///?#");
        assertNull(uri.getScheme());
        assertNull(uri.getAuthority());
        assertEquals(":///:",uri.getPath());
        assertEquals("",uri.getQuery());
        assertEquals(":///?#",uri.getFragment());
    }

    /**
     * This test checks to see if the transition between scheme and authority is implemented correctly by the parser.
     * This test improves the quality of the test suite since it ensures that the parser is able to correctly identify
     * the transitions that are present in the URI.
     */
    @Test(timeout = 5000)
    public void testTransition_schemeAndAuthority() {
        URI uri = new URIParser().parse("https://authority");
        assertEquals("https", uri.getScheme());
        assertEquals("authority", uri.getAuthority());
    }

    /**
     * This test checks to see if the transition between scheme and path is implemented correctly.
     * This test improves the quality of the test suite since it ensures that the parser is able to correctly identify
     * the transitions that are present in the URI.
     */
    @Test(timeout = 5000)
    public void testTransition_schemeAndPath() {
        URI uri = new URIParser().parse("https:path");
        assertEquals("https", uri.getScheme());
        assertEquals("path", uri.getPath());
    }

    /**
     * This test checks to see if the transition between scheme and path is implemented correctly, given special
     * characters. This is to ensure that the parser does not mis-recognize the scheme or the path in the transition
     */
    @Test(timeout = 5000)
    public void testTransition_specialCharacterSchemeAndPath() {
        URI uri = new URIParser().parse("&path1:path2:path3");
        assertEquals("&path1", uri.getScheme());
        assertEquals("path2:path3", uri.getPath());
    }

    /**
     * This test checks to see if the transition between scheme and path is implemented correctly, given special
     * characters. This is to ensure that the parser does not mis-recognize the scheme or the path in the transition
     */
    @Test(timeout = 5000)
    public void testTransition_schemeAndPathSpecialCharactersV2(){
        URI uri = new URIParser().parse("&scheme::/&path1:/&path2");
        assertEquals("&scheme", uri.getScheme());
        assertEquals(":/&path1:/&path2", uri.getPath());
    }

    /**
     * This test checks to see if the transition between scheme and query is implemented correctly.
     * This test improves the quality of the test suite since it ensures that the parser is able to correctly identify
     * the transitions that are present in the URI.
     */
    @Test(timeout = 5000)
    public void testTransition_schemeAndQuery() {
        URI uri = new URIParser().parse("https:?Query");
        assertEquals("https", uri.getScheme());
        assertEquals("Query", uri.getQuery());

    }

    /**
     * This test checks to see if the transition between scheme and query has been implemented correctly, given that
     * the URI has special characters. This is done to ensure that the parser does not mis-recognize the elements in the
     * URI.
     */
    @Test(timeout = 5000)
    public void testTransition_schemeAndQueryWithSpecialCharacters() {
        URI uri = new URIParser().parse("https:?:///?Query");
        assertEquals("https", uri.getScheme());
        assertEquals(":///?Query", uri.getQuery());

    }

    /**
     * This test checks to see if the transition between scheme and fragment has been correctly implemented.
     * This test improves the quality of the test suite since it ensures that the parser is able to correctly identify
     * the transitions that are present in the URI.
     */
    @Test(timeout = 5000)
    public void testTransition_schemeAndFragment() {
        URI uri = new URIParser().parse("https:#Fragment");
        assertEquals("https", uri.getScheme());
        assertEquals("Fragment", uri.getFragment());
    }

    /**
     * This test checks that the transition from scheme to fragment is correctly implemented given that the URI has special
     * characters. This is done to ensure that special characters can be used in the URI, and that the parser is still correctly
     * able to distinguish the scheme and fragment in the URI.
     */
    @Test(timeout = 5000)
    public void testTransition_schemeAndFragmentWithSpecialCharacters(){
        URI uri = new URIParser().parse("https:#:///?#Fragment");
        assertEquals("https", uri.getScheme());
        assertEquals(":///?#Fragment", uri.getFragment());
    }


    /**
     * This test checks that the transition from authority to the path is implemented correctly, given there being a
     * special character ':'. This test improves the quality of the test suite, as the colon is not considered as a
     * legal character in this case as it is used to transition, thus by specifically testing it, we are ensuring that
     * the transition between the authority and the path is correct.
     */
    @Test(timeout = 5000)
    public void testTransition_authorityAndPathWithColon() {
        URI uri = new URIParser().parse("//authority/:baboons");
        assertEquals("authority", uri.getAuthority());
        assertEquals("/:baboons", uri.getPath());
    }

    /**
     * This test checks that the transition from the authority to the path is implemented correctly, given there being a
     * special character '/'. This test improves the quality of the test suite, as the slash is not considered as a
     * legal character in this case as it is used to transition, thus by specifically testing it, we are ensuring that
     * the transition between the authority and the path is correct and that the parser is able to distinguish the slash
     * of the path vs the slash of the authority.
     */
    @Test(timeout = 5000)
    public void testTransition_authorityAndPathWithSlash(){
        URI uri=new URIParser().parse("//authority//path");
        assertEquals("authority",uri.getAuthority());
        assertEquals("//path",uri.getPath());
    }

    /**
     * This test checks that the transition between authority and query is implemented correctly.
     * This test improves the quality of the test suite since it ensures that the parser is able to correctly identify
     * the transitions that are present in the URI.
     */
    @Test(timeout = 5000)
    public void testTransition_authorityAndQuery(){
        URI uri=new URIParser().parse("//authority?Query");
        assertEquals("authority",uri.getAuthority());
        assertEquals("Query",uri.getQuery());
    }

    /**
     * This test checks that the transition between authority and query have been implemented correctly given that
     * there are special characters in the URI. This is to ensure that the parser is able to distinguish the special
     * characters and the elements correctly.
     */
    @Test(timeout = 5000)
    public void testTransition_authorityAndQueryWithSpecialCharacters(){
        URI uri=new URIParser().parse("//authority?//:Query");
        assertEquals("authority",uri.getAuthority());
        assertEquals("//:Query",uri.getQuery());
    }

    /**
     * This test checks that the transition from the authority to the fragment has been implemented correctly.
     * This test improves the quality of the test suite since it ensures that the parser is able to correctly identify
     * the transitions that are present in the URI.
     */
    @Test(timeout = 5000)
    public void testTransition_authorityAndFragment(){
        URI uri=new URIParser().parse("//authority#Fragment");
        assertEquals("authority",uri.getAuthority());
        assertEquals("Fragment",uri.getFragment());
    }

    /**
     * This test checks that the transition between the authority and the fragment has been implemented correctly, given
     * there being special characters which are legal and can be used to trigger other elements in the URI.
     */
    @Test(timeout = 5000)
    public void testTransition_authorityAndFragmentWithSpecialCharacters(){
        URI uri=new URIParser().parse("//authority##?://Fragment");
        assertEquals("authority",uri.getAuthority());
        assertEquals("#?://Fragment",uri.getFragment());
    }

    /**
     * This test checks that the transition between path and query has been implemented correctly. This test improves
     * the quality of the test suite since it ensures that the parser is able to correctly identify the transitions
     * that are present in the URI.
     */
    @Test(timeout = 5000)
    public void testTransition_pathAndQuery() {
        URI uri = new URIParser().parse(":path?Query");
        assertEquals(":path", uri.getPath());
        assertEquals("Query", uri.getQuery());
    }

    /**
     * This test checks that the transition between path and query has been implemented correctly given
     * there being special characters which are legal and can be used to trigger other elements in the URI.
     */
    @Test(timeout = 5000)
    public void testTransition_pathAndQueryWithSpecialCharacters(){
        URI uri=new URIParser().parse("path/?:/?Query");
        assertEquals("path/",uri.getPath());
        assertEquals(":/?Query",uri.getQuery());
    }

    /**
     * This test checks that the transition between the path and the fragment has been implemented correctly.
     * This test improves the quality of the test suite since it ensures that the parser is able to correctly identify
     * the transitions that are present in the URI.
     */
    @Test(timeout = 5000)
    public void testTransition_pathAndFragment(){
        URI uri=new URIParser().parse("path#Fragment");
        assertEquals("path",uri.getPath());
        assertEquals("Fragment",uri.getFragment());
    }

    /**
     * This test checks that the transition between the path and the fragment has been implemented correctly, given
     * there being special characters which are legal and can be used to trigger other elements in the URI.
     */
    @Test(timeout = 5000)
    public void testTransition_pathAndFragmentWithSpecialCharacters(){
        URI uri=new URIParser().parse("path##?://Fragment");
        assertEquals("path",uri.getPath());
        assertEquals("#?://Fragment",uri.getFragment());
    }

    /**
     * This test checks that the transition between query and fragment has been implemented correctly.
     * This test improves the quality of the test suite since it ensures that the parser is able to correctly identify
     * the transitions that are present in the URI.
     */

    @Test(timeout = 5000)
    public void testTransition_queryAndFragment(){
        URI uri=new URIParser().parse("?Query#Fragment");
        assertEquals("Query",uri.getQuery());
        assertEquals("Fragment",uri.getFragment());
    }

    /**
     * This test checks that the transition between query and fragment has been implemented correctly, given
     * there being special characters which are legal and can be used to trigger other elements in the URI.
     */

    @Test(timeout = 5000)
    public void testTransition_queryAndFragmentWithSpecialCharacters(){
        URI uri=new URIParser().parse("?Query#://?#Fragment");
        assertEquals("Query",uri.getQuery());
        assertEquals("://?#Fragment",uri.getFragment());
    }


    /**
     * This test checks the transition between authority and path given that the authority is empty. Since the implementation
     * is not known, we are not sure if an empty authority will cause the parser to mis-interpret the string. Thus, it
     * is tested and adds to the quality of the test suite as an empty authority is viable, and therefore must behave
     * correctly which the test confirms.
     */
    @Test(timeout = 5000)
    public void testTransition_emptyAuthorityAndPath(){
        URI uri=new URIParser().parse("///Path");
        assertEquals("",uri.getAuthority());
        assertEquals("/Path",uri.getPath());
    }

    /**
     * This test checks the transition between authority and query given that the authority is empty. Since the implementation
     * is not known, we are not sure if an empty authority will cause the parser to mis-interpret the string. Thus, it
     * is tested and adds to the quality of the test suite as an empty authority is viable, and therefore must behave
     * correctly which the test confirms.
     */
    @Test(timeout = 5000)
    public void testTransition_emptyAuthorityAndQuery(){
        URI uri=new URIParser().parse("//?:/Query");
        assertEquals("",uri.getAuthority());
        assertEquals(":/Query",uri.getQuery());
    }

    /**
     * This test checks the transition between authority and fragment given that the authority is empty. Since the implementation
     * is not known, we are not sure if an empty authority will cause the parser to mis-interpret the string. Thus, it
     * is tested and adds to the quality of the test suite as an empty authority is viable, and therefore must behave
     * correctly which the test confirms.
     */
    @Test(timeout = 5000)
    public void testTransition_emptyAuthorityAndFragment(){
        URI uri=new URIParser().parse("//#?://#Fragment");
        assertEquals("",uri.getAuthority());
        assertEquals("?://#Fragment",uri.getFragment());
    }

    /**
     * This test checks the transition between query and fragment given that the authority is empty. Since the implementation
     * is not known, we are not sure if an empty query will cause the parser to mis-interpret the string. Thus, it
     * is tested and adds to the quality of the test suite as an empty query is viable, and therefore must behave
     * correctly which the test confirms.
     */
    @Test(timeout = 5000)
    public void testTransition_emptyQueryAndFragment(){
        URI uri=new URIParser().parse("?#?://#Fragment");
        assertEquals("",uri.getQuery());
        assertEquals("?://#Fragment",uri.getFragment());
    }


    /**
     * This test checks is a special character ':' is inserted which represents the scheme is inserted by itself ,and
     * does not follow the javadoc of having at least one legal string before all the elements are marked as null. This
     * test adds to the quality of the test suite as it ensures that the the parser is able to recognize an invalid input
     * and correctly handle it, which this test ensures.
     */
    @Test(timeout = 5000)
    public void testJustSpecialCharacterColon(){
        URI uri=new URIParser().parse(":");
        assertNull(uri.getScheme());
        assertNull(uri.getAuthority());
        assertEquals(":",uri.getPath());
        assertNull(uri.getQuery());
        assertNull(uri.getFragment());
    }

    /**
     * This test checks that the parser can correctly distinguish a path with a single slash, and the lack of
     * having anything else as nulls for the other elements of the URI. I.E. the parser does not confuse the '/' for
     * any other element other than the path in the URI
     */
    @Test(timeout = 5000)
    public void testJustSpecialCharacterSlash(){
        URI uri=new URIParser().parse("/");
        assertNull(uri.getScheme());
        assertNull(uri.getAuthority());
        assertEquals("/",uri.getPath());
        assertNull(uri.getQuery());
        assertNull(uri.getFragment());
    }

    /**
     * This test checks to see that when only a question mark is provided the parser correctly identifies it as a "trigger"
     * for the query and not any other element, thus asserting the other elements with null.
     */
    @Test(timeout = 5000)
    public void testJustSpecialCharacterQuestion(){
        URI uri=new URIParser().parse("?");
        assertNull(uri.getScheme());
        assertNull(uri.getAuthority());
        assertNull(uri.getPath());
        assertEquals("",uri.getQuery());
        assertNull(uri.getFragment());
    }

    /**
     * This test checks to see that when only a hash is provided the parser correctly identifies it as a "trigger"
     * for the fragment and not any other element, thus asserting the other elements with null.
     */
    @Test(timeout = 5000)
    public void testJustSpecialCharacterHash(){
        URI uri=new URIParser().parse("#");
        assertNull(uri.getScheme());
        assertNull(uri.getAuthority());
        assertNull(uri.getPath());
        assertNull(uri.getQuery());
        assertEquals("",uri.getFragment());
    }

    /**
     * This test checks if the parser is able to handle a completely empty string. This test adds to the quality of the
     * test suite as, it ensures that the parser correctly identifies that an empty string is provided, as such an input
     * is viable and thus ensures that the parser is able to correctly handle an empty string, which this test ensures.
     */
    @Test(timeout = 5000)
    public void testJustEmptyString(){
        URI uri=new URIParser().parse("");
        assertNull(uri.getScheme());
        assertNull(uri.getAuthority());
        assertNull(uri.getPath());
        assertNull(uri.getQuery());
        assertNull(uri.getFragment());
    }
}
