package uk.co.drnaylor.minecraft.quickstart.commands.teleport;

import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.entity.living.player.Player;
import uk.co.drnaylor.minecraft.quickstart.api.PluginModule;
import uk.co.drnaylor.minecraft.quickstart.internal.CommandBase;
import uk.co.drnaylor.minecraft.quickstart.internal.annotations.Modules;
import uk.co.drnaylor.minecraft.quickstart.internal.annotations.NoWarmup;
import uk.co.drnaylor.minecraft.quickstart.internal.annotations.Permissions;

/**
 * Sends a request to a player to teleport to them, using click handlers.
 */
@Permissions(root = "teleport")
@Modules(PluginModule.TELEPORT)
@NoWarmup
public class TeleportAskCommand extends CommandBase<Player> {
    @Override
    public CommandSpec createSpec() {
        return null;
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public CommandResult executeCommand(Player src, CommandContext args) throws Exception {
        return null;
    }
}
