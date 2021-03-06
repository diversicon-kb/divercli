package eu.kidf.diversicon.cli.commands;

import static eu.kidf.diversicon.core.internal.Internals.checkArgument;
import static eu.kidf.diversicon.core.internal.Internals.checkNotNull;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import eu.kidf.diversicon.cli.DiverCli;

/**
 * 
 * @since 0.1.0
 *
 */
@Parameters(separators = "=", commandDescription = "Display detailed import log of given import id.")
public class ImportShowCommand implements DiverCliCommand {

    /**
     * @since 0.1.0
     */
    public static final String CMD = "import-show";
    
    private static final Logger LOG = LoggerFactory.getLogger(ImportShowCommand.class);

    private DiverCli diverCli;
        
    @Parameter(description = "the import id to show", required=true, arity = 1)
    List<Long> importIdToShow = null;
   
    /**
     * @since 0.1.0
     */
    public ImportShowCommand(DiverCli diverCli){
        checkNotNull(diverCli);
        this.diverCli = diverCli;
    }
    
        /**
     * {@inheritDoc}
     * @since 0.1.0
     */
@Override
    public void configure(){       
        checkArgument(importIdToShow.get(0) >= 0, "Invalid import id! Must be greater or equal than 0, found instead " + importIdToShow);
    }
    
        /**
     * {@inheritDoc}
     * @since 0.1.0
     */
@Override
    public void run(){        

        diverCli.connect();
        LOG.info("\n");
        LOG.info(diverCli.getDiversicon().formatImportJob(importIdToShow.get(0), true));
    }
    
        /**
     * {@inheritDoc}
     * @since 0.1.0
     */
@Override
    public String getName() {
        return CMD;
    }
}
