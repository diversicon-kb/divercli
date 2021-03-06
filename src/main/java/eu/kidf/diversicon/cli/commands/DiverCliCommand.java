package eu.kidf.diversicon.cli.commands;

/**
 * Common interface for {@link eu.kidf.diversicon.cli.DiverCli DiverCli} commands
 * 
 * @since 0.1.0
 */
public interface DiverCliCommand {
    
    /**
     * Configures the command
     * 
     * @since 0.1.0 
     */
    void configure();

    /**
     * Runs the command
     * 
     * @since 0.1.0 
     */    
    void run();
    
    /**
     * Retunrs the name of the command.
     * 
     * @since 0.1.0 
     */    
    String getName();    
}
