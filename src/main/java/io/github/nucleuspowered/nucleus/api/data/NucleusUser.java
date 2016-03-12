/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.api.data;

import com.flowpowered.math.vector.Vector3d;
import io.github.nucleuspowered.nucleus.Nucleus;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.annotation.NonnullByDefault;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents data held about a user in {@link Nucleus}.
 */
public interface NucleusUser {

    /**
     * Returns the user associated with this data.
     *
     * @return The {@link User}.
     */
    @NonnullByDefault User getUser();

    /**
     * Returns the {@link UUID} of the user (shorthand for {@link User#getUniqueId()}.
     *
     * @return The {@link UUID}
     */
    @NonnullByDefault UUID getUniqueID();

    /**
     * Gets the {@link MuteData} associated with this user, if any.
     *
     * @return An {@link Optional} that might contain the mute data.
     */
    Optional<MuteData> getMuteData();

    /**
     * Sets the {@link MuteData} associated with this user, if any.
     *
     * @param data The {@link MuteData}
     */
    void setMuteData(MuteData data);

    /**
     * Removes the {@link MuteData} associated with this user.
     */
    void removeMuteData();

    /**
     * Gets whether the player is a Social Spy.
     *
     * @return <code>true</code> if the player is a social spy, <code>false</code> otherwise.
     */
    boolean isSocialSpy();

    /**
     * Sets whether the player is a Social Spy. Note that they must also have the command permission (quickstart.socialspy.base).
     *
     * @param socialSpy <code>true</code> if they should be a spy.
     * @return <code>true</code> if the change was made.
     */
    boolean setSocialSpy(boolean socialSpy);

    /**
     * Gets whether Nucleus thinks the player should be invulnerable. Note, this means the player has been subject to
     * the /god command.
     *
     * @return <code>true</code> if so.
     */
    boolean isInvulnerable();

    /**
     * Sets whether Nucleus thinks the player should be invulnerable. Note, this is the same as the player being subject to
     * the /god command.
     *
     * @param invuln <code>true</code> if so, <code>false</code> otherwise.
     * @return <code>true</code> if successful.
     */
    boolean setInvulnerable(boolean invuln);

    /**
     * Gets whether Nucleus thinks the player should be flying. Note, this means the player has been subject to
     * the /god command.
     *
     * @return <code>true</code> if so.
     */
    boolean isFlying();

    /**
     * Sets whether Nucleus thinks the player should be flying. This does not necessarily mean that the player is
     * actually flying.
     *
     * @param fly <code>true</code> if so, <code>false</code> otherwise.
     * @return <code>true</code> if successful.
     */
    boolean setFlying(boolean fly);

    /**
     * If the player is jailed, gets the {@link JailData}
     *
     * @return If it exists, an {@link Optional} wrapped {@link JailData}
     */
    Optional<JailData> getJailData();

    /**
     * Gets the time the player last logged in.
     *
     * @return The {@link Instant}
     */
    Instant getLastLogin();

    /**
     * Gets the time the player last logged out.
     *
     * @return The {@link Instant}
     */
    Instant getLastLogout();

    /**
     * Gets the specified home for the player.
     *
     * @param home The name of the home to get.
     * @return An {@link Optional} containing the {@link WarpLocation}, if it exists.
     */
    Optional<WarpLocation> getHome(String home);

    /**
     * Gets all of the homes for a player.
     *
     * @return An {@link Map} containing the {@link WarpLocation}s of the homes, using the name of the homes as a key.
     */
    Map<String, WarpLocation> getHomes();

    /**
     * Sets a player's home. Will not overwrite a home that exists. Does not respect limits set in permissions and options.
     *
     * @param home The name of the home to create.
     * @param location The {@link Location} of the home.
     * @param rotation The {@link Vector3d} that represents the rotation.
     * @return <code>true</code> if successful.
     */
    boolean setHome(String home, Location<World> location, Vector3d rotation);

    /**
     * Deletes the named home.
     *
     * @param home The name of the home to delete.
     * @return <code>true</code> if it was deleted.
     */
    boolean deleteHome(String home);

    /**
     * Gets whether the player allows others to teleport to them.
     *
     * @return <code>true</code> if so.
     */
    boolean isTeleportToggled();

    /**
     * Sets whether the player allows others to teleport to them.
     *
     * @param toggle <code>true</code> if so.
     */
    void setTeleportToggled(boolean toggle);

    Optional<Text> getNicknameWithPrefix();

    /**
     * Gets the player's nickname as Text.
     *
     * @return The player's nickname.
     */
    Optional<Text> getNicknameAsText();

    /**
     * Gets the player's nickname as a String object, using legacy colour codes prefixed with an ampersand.
     *
     * @return The player's nickname
     */
    Optional<String> getNicknameAsString();

    /**
     * Sets the player's nickname, using legacy colour/style codes prefixed with an ampersand.
     *
     * @param nick The nickname to set.
     */
    void setNickname(String nick);

    /**
     * Removes the player's nickname.
     */
    void removeNickname();

    /**
     * Gets whether the user has a powertool bound to the {@link ItemType} specified, and what that is.
     * @param item The {@link ItemType} to check.
     *
     * @return An {@link Optional} that contains the list of commands to execute if there is a powertool.
     */
    Optional<List<String>> getPowertoolForItem(ItemType item);

    /**
     * Gets whether the user has powertools enabled.
     *
     * @return <code>true</code> if interacting <code>might</code> activate a powertool.
     */
    boolean isPowertoolToggled();

    /**
     * Sets whether the user has powertools enabled.
     *
     * @param set Sets whether powertools are enabled for this user.
     */
    void setPowertoolToggle(boolean set);

    /**
     * Gets the UUID of the users that should be ignored.
     *
     * @return The {@link List} of {@link UUID}s that represent the users that are ignored.
     */
    List<UUID> getIgnoreList();

    /**
     * Adds a user to the ignore list.
     *
     * @param uuid The {@link UUID} of the user to ignore.
     * @return <code>true</code> if successful.
     */
    boolean addToIgnoreList(UUID uuid);

    /**
     * Remove a user from the ignore list.
     *
     * @param uuid The {@link UUID} of the user to stop ignoring.
     * @return <code>true</code> if successful.
     */
    boolean removeFromIgnoreList(UUID uuid);
}
