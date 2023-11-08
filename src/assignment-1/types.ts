export interface Entity {
    email?: string;
    provider?: string;
    inbox?: number;
    sent?: number;
    spam?: number;
}

export interface ProviderEmissions {
    [key: string]: {
        inbox: number;
        sent: number;
        spam: number
    }
}

export interface EntityHandlers {
    [key: string]: (entity: Entity) => string
}
