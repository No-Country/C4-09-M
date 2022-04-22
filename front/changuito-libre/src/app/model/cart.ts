import { Product } from './../components/searcher/product';

enum enumStatus {
  CLOSED = 'CLOSED',
  CANCELED = 'CANCELED',
  DENIED = 'DENIED',
  APPROVED = 'APPROVED'
}

export class Cart {

  constructor(private ticket: string,
    public clientId: number,
    public merchandiserId: number,
    private enumStatus: enumStatus,
    private updateDate: Date,
    private creationDate: Date,
    private products: Product[]

  ) { }

}
