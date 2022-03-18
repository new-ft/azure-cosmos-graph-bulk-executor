package com.azure.graph.bulk.impl.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GremlinEdgeTest {

    @Test
    void GoodEdgePassesValidation() {
        GremlinEdge edge = GremlinEdge.builder()
                .id("Good")
                .label("Edge")
                .partitionKey(GremlinPartitionKey.builder().fieldName("Field").value("Value").build())
                .sourceVertexInfo(new GremlinEdgeVertexInfo("Source"))
                .destinationVertexInfo(new GremlinEdgeVertexInfo("Destination"))
                .build();

        assertDoesNotThrow(edge::validate);
    }

    @Test
    void EmptyIdThrowsException() {
        GremlinEdge edge = GremlinEdge.builder()
                .id("")
                .label("Edge")
                .partitionKey(GremlinPartitionKey.builder().fieldName("Field").value("Value").build())
                .sourceVertexInfo(new GremlinEdgeVertexInfo("Source"))
                .destinationVertexInfo(new GremlinEdgeVertexInfo("Destination"))
                .build();

        assertThrows(IllegalStateException.class, edge::validate);
    }

    @Test
    void NullIdThrowsException() {
        GremlinEdge edge = GremlinEdge.builder()
                .label("Edge")
                .partitionKey(GremlinPartitionKey.builder().fieldName("Field").value("Value").build())
                .sourceVertexInfo(new GremlinEdgeVertexInfo("Source"))
                .destinationVertexInfo(new GremlinEdgeVertexInfo("Destination"))
                .build();

        assertThrows(IllegalStateException.class, edge::validate);
    }

    @Test
    void EmptyLabelThrowsException() {
        GremlinEdge edge = GremlinEdge.builder()
                .id("Bad")
                .label("")
                .partitionKey(GremlinPartitionKey.builder().fieldName("Field").value("Value").build())
                .sourceVertexInfo(new GremlinEdgeVertexInfo("Source"))
                .destinationVertexInfo(new GremlinEdgeVertexInfo("Destination"))
                .build();

        assertThrows(IllegalStateException.class, edge::validate);
    }

    @Test
    void NullLabelThrowsException() {
        GremlinEdge edge = GremlinEdge.builder()
                .id("Bad")
                .partitionKey(GremlinPartitionKey.builder().fieldName("Field").value("Value").build())
                .sourceVertexInfo(new GremlinEdgeVertexInfo("Source"))
                .destinationVertexInfo(new GremlinEdgeVertexInfo("Destination"))
                .build();

        assertThrows(IllegalStateException.class, edge::validate);
    }

    @Test
    void NullSourceThrowsException() {
        GremlinEdge edge = GremlinEdge.builder()
                .id("Bad")
                .label("Edge")
                .destinationVertexInfo(new GremlinEdgeVertexInfo("Destination"))
                .partitionKey(GremlinPartitionKey.builder().fieldName("Field").value("Value").build())
                .build();

        assertThrows(IllegalStateException.class, edge::validate);
    }

    @Test
    void NullDestinationThrowsException() {
        GremlinEdge edge = GremlinEdge.builder()
                .id("Bad")
                .label("Edge")
                .sourceVertexInfo(new GremlinEdgeVertexInfo("Source"))
                .partitionKey(GremlinPartitionKey.builder().fieldName("Field").value("Value").build())
                .build();

        assertThrows(IllegalStateException.class, edge::validate);
    }

    @Test
    void NullPartitionKeyThrowsException() {
        GremlinEdge edge = GremlinEdge.builder()
                .id("Bad")
                .label("Edge")
                .sourceVertexInfo(new GremlinEdgeVertexInfo("Source"))
                .destinationVertexInfo(new GremlinEdgeVertexInfo("Destination"))
                .build();

        assertThrows(IllegalStateException.class, edge::validate);
    }
}
