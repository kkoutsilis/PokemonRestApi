package com.example.PokemonDB.dao;

import com.example.PokemonDB.model.Pokemon;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePokemonDataAccessService implements PokemonDao {

    private static List<Pokemon> DB = new ArrayList<>();

    @Override
    public int insertPokemon(UUID id, Pokemon pokemon) {
        DB.add(new Pokemon(id, pokemon.getName(), pokemon.getType()));
        return 1;
    }

    @Override
    public List<Pokemon> selectAllPokemon() {
        return DB;
    }

    @Override
    public Optional<Pokemon> selectPokemonById(UUID id) {
        return DB.stream().
                filter(pokemon -> pokemon.getId().equals(id)).
                findFirst();
    }

    @Override
    public int deletePokemonById(UUID id) {
        Optional<Pokemon> pokemonToDelete = selectPokemonById(id);
        if (pokemonToDelete.isEmpty()) {
            return 0;
        }
        DB.remove(pokemonToDelete.get());
        return 1;
    }

    @Override
    public int updatePokemonById(UUID id, Pokemon pokemon) {
        return selectPokemonById(id).map(pokemonToUpdate -> {
            int indexOfPokemonToUpdate = DB.indexOf(pokemonToUpdate);
            if (indexOfPokemonToUpdate >= 0) {
                DB.set(indexOfPokemonToUpdate, new Pokemon(id, pokemon.getName(), pokemon.getType()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    @Override
    public List<Pokemon> selectPokemonByType(String type) {
        List<Pokemon> pokemonByType = new ArrayList<>();
        for(Pokemon pokemon : DB ){
            if (pokemon.getType().equals(type)){
                pokemonByType.add(pokemon);
            }
        }
        return pokemonByType;
    }
}
