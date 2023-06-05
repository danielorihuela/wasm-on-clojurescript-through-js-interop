use wasm_bindgen::prelude::*;

#[wasm_bindgen]
pub fn add(a: u8, b: u8) -> u8 {
    a + b
}