pub extern crate prost;
pub use tonic::codec as tonic_prost;

pub mod demo {
    pub mod v1 {
        include!(concat!(env!("CARGO_MANIFEST_DIR"), "/src/gen/demo/v1/demo.v1.rs"));
    }
}
