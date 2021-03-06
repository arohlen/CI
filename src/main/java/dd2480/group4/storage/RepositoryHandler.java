package dd2480.group4.storage;

import java.io.IOException;
import java.nio.file.Path;

/**
 * The interface for handling repositories.
 */
public interface RepositoryHandler {

    /**
     * Creates a temporary directory and returns the path to it.
     *
     * @return the path to the directory
     * @throws IOException if it fails to create the repository
     */
    Path createDirectory() throws IOException;

    /**
     * Clones a repository to the given path.
     *
     * @param path the location where the repositories is cloned to.
     * @param repo the http-address to the repo to be cloned.
     */
    void cloneGit(Path path, String repo) throws IOException, InterruptedException;

    /**
     * Clones a repository to the given path.
     *
     * @param path   the location where the repositories is cloned to.
     * @param repo   the http-address to the repo to be cloned.
     * @param hashId the commit hash to checkout
     */
    void cloneGit(Path path, String repo, String hashId) throws IOException, InterruptedException;

    /**
     * Deletes the directory at the given path.
     *
     * @param path the path to the directory which is to be deleted.
     */
    void deleteDirectory(Path path) throws IOException;


}
