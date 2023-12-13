/*
 * This file is generated by jOOQ.
 */
package az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables;


import az.rock.flyjob.auth.dataAccess.model.jooq.auth.Auth;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.Keys;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.records.RoleAuthorityRecord;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RoleAuthority extends TableImpl<RoleAuthorityRecord> {

    private static final long serialVersionUID = -1273593038;

    /**
     * The reference instance of <code>auth.role_authority</code>
     */
    public static final RoleAuthority ROLE_AUTHORİTY = new RoleAuthority();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RoleAuthorityRecord> getRecordType() {
        return RoleAuthorityRecord.class;
    }

    /**
     * The column <code>auth.role_authority.authority_id</code>.
     */
    public final TableField<RoleAuthorityRecord, UUID> AUTHORİTY_İD = createField(DSL.name("authority_id"), org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>auth.role_authority.role_id</code>.
     */
    public final TableField<RoleAuthorityRecord, UUID> ROLE_İD = createField(DSL.name("role_id"), org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

    /**
     * Create a <code>auth.role_authority</code> table reference
     */
    public RoleAuthority() {
        this(DSL.name("role_authority"), null);
    }

    /**
     * Create an aliased <code>auth.role_authority</code> table reference
     */
    public RoleAuthority(String alias) {
        this(DSL.name(alias), ROLE_AUTHORİTY);
    }

    /**
     * Create an aliased <code>auth.role_authority</code> table reference
     */
    public RoleAuthority(Name alias) {
        this(alias, ROLE_AUTHORİTY);
    }

    private RoleAuthority(Name alias, Table<RoleAuthorityRecord> aliased) {
        this(alias, aliased, null);
    }

    private RoleAuthority(Name alias, Table<RoleAuthorityRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> RoleAuthority(Table<O> child, ForeignKey<O, RoleAuthorityRecord> key) {
        super(child, key, ROLE_AUTHORİTY);
    }

    @Override
    public Schema getSchema() {
        return Auth.AUTH;
    }

    @Override
    public UniqueKey<RoleAuthorityRecord> getPrimaryKey() {
        return Keys.PK_ROLE_AUTHORİTY;
    }

    @Override
    public List<UniqueKey<RoleAuthorityRecord>> getKeys() {
        return Arrays.<UniqueKey<RoleAuthorityRecord>>asList(Keys.PK_ROLE_AUTHORİTY);
    }

    @Override
    public List<ForeignKey<RoleAuthorityRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<RoleAuthorityRecord, ?>>asList(Keys.ROLE_AUTHORİTY__FK_ROLAUT_ON_AUTHORİTY_ENTİTY, Keys.ROLE_AUTHORİTY__FK_ROLAUT_ON_ROLE_ENTİTY);
    }

    public Authorities authorities() {
        return new Authorities(this, Keys.ROLE_AUTHORİTY__FK_ROLAUT_ON_AUTHORİTY_ENTİTY);
    }

    public Roles roles() {
        return new Roles(this, Keys.ROLE_AUTHORİTY__FK_ROLAUT_ON_ROLE_ENTİTY);
    }

    @Override
    public RoleAuthority as(String alias) {
        return new RoleAuthority(DSL.name(alias), this);
    }

    @Override
    public RoleAuthority as(Name alias) {
        return new RoleAuthority(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RoleAuthority rename(String name) {
        return new RoleAuthority(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RoleAuthority rename(Name name) {
        return new RoleAuthority(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<UUID, UUID> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}