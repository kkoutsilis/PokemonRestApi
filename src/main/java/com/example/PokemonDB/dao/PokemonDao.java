package com.example.PokemonDB.dao;

import com.example.PokemonDB.model.Pokemon;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PokemonDao {

    int insertPokemon(UUID id , Pokemon pokemon);

    default int insertPokemon(Pokemon pokemon){
        UUID id  = UUID.randomUUID();
        return  insertPokemon(id,pokemon);
    }

    List<Pokemon> selectAllPokemon();

    Optional<Pokemon> selectPokemonById (UUID id);

    int deletePokemonById(UUID id);

    int updatePokemonById(UUID id,Pokemon pokemon);

    List<Pokemon> selectPokemonByType(String type);
}
